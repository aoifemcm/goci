package uk.ac.ebi.spot.goci.curation.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import uk.ac.ebi.spot.goci.builder.AssociationBuilder;
import uk.ac.ebi.spot.goci.builder.EfoTraitBuilder;
import uk.ac.ebi.spot.goci.builder.StudyBuilder;
import uk.ac.ebi.spot.goci.model.Association;
import uk.ac.ebi.spot.goci.model.EfoTrait;
import uk.ac.ebi.spot.goci.model.Study;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by emma on 26/02/2016.
 *
 * @author emma
 *         <p>
 *         Test of PublishStudyCheckService.java
 */
@RunWith(MockitoJUnitRunner.class)
public class PublishStudyCheckServiceTest {

    private PublishStudyCheckService publishStudyCheckService;

    @Mock
    private CheckEfoTermAssignmentService checkEfoTermAssignmentService;

    private static final EfoTrait EFO1 =
            new EfoTraitBuilder().setId(987L)
                    .setTrait("asthma")
                    .setUri("http://www.ebi.ac.uk/efo/EFO_0000270")
                    .build();

    private static final EfoTrait EFO2 = new EfoTraitBuilder()
            .setId(988L)
            .setTrait("atrophic rhinitis")
            .setUri("http://www.ebi.ac.uk/efo/EFO_0007159")
            .build();

    private static final Association ASS_APPROVED =
            new AssociationBuilder().setId(801L)
                    .setSnpApproved(true).build();

    private static final Association ASS_NOT_APPROVED =
            new AssociationBuilder().setId(803L)
                    .setSnpApproved(false).build();

    private static final Study STUDY_EFO_TRAIT_ASSIGNED_ASS_APPROVED =
            new StudyBuilder().setId(802L)
                    .setEfoTraits(Arrays.asList(EFO1, EFO2))
                    .setAssociations(Collections.singletonList(ASS_APPROVED))
                    .build();

    private static final Study STUDY_NO_EFO_TRAIT =
            new StudyBuilder().setId(802L)
                    .setAssociations(Collections.singletonList(ASS_NOT_APPROVED))
                    .build();

    @Before
    public void setUp() throws Exception {
        publishStudyCheckService = new PublishStudyCheckService(checkEfoTermAssignmentService);
    }

    @Test
    public void testMocks() {
        // Test mock creation
        assertNotNull(checkEfoTermAssignmentService);
    }

    @Test
    public void testStudyWithEfoTraitsAndApprovedAssociation() throws Exception {

        when(checkEfoTermAssignmentService.checkStudyEfoAssignment(STUDY_EFO_TRAIT_ASSIGNED_ASS_APPROVED)).thenReturn(true);

        publishStudyCheckService.runChecks(STUDY_EFO_TRAIT_ASSIGNED_ASS_APPROVED,
                                           Collections.singletonList(ASS_APPROVED));
        verify(checkEfoTermAssignmentService, times(1)).checkStudyEfoAssignment(STUDY_EFO_TRAIT_ASSIGNED_ASS_APPROVED);
        assertTrue(checkEfoTermAssignmentService.checkStudyEfoAssignment(STUDY_EFO_TRAIT_ASSIGNED_ASS_APPROVED));
        assertNull(publishStudyCheckService.runChecks(STUDY_EFO_TRAIT_ASSIGNED_ASS_APPROVED,
                                                      Collections.singletonList(ASS_APPROVED)));
    }

    @Test
    public void testStudyWithoutEfoTraitsAndAssociationNotApproved() {
        when(checkEfoTermAssignmentService.checkStudyEfoAssignment(STUDY_NO_EFO_TRAIT)).thenReturn(false);

        publishStudyCheckService.runChecks(STUDY_NO_EFO_TRAIT,
                                           Collections.singletonList(ASS_NOT_APPROVED));
        verify(checkEfoTermAssignmentService, times(1)).checkStudyEfoAssignment(STUDY_NO_EFO_TRAIT);
        assertFalse(checkEfoTermAssignmentService.checkStudyEfoAssignment(STUDY_NO_EFO_TRAIT));
        assertNotNull(publishStudyCheckService.runChecks(STUDY_NO_EFO_TRAIT,
                                                         Collections.singletonList(ASS_APPROVED)));
        assertThat(publishStudyCheckService.runChecks(STUDY_NO_EFO_TRAIT,
                                                      Collections.singletonList(ASS_APPROVED))
                           .contains("No EFO trait assigned and some SNP associations have not been approved for study"));

    }
}
