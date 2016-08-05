package uk.ac.ebi.spot.goci.model;

/**
 * Created by emma on 28/04/2016.
 *
 * @author emma
 *         <p>
 *         Enum class to hold various events the curation system should track
 */
public enum EventType {
    STUDY_CREATION,

    // Status assignment
    STUDY_STATUS_CHANGE_LEVEL_1_ANCESTRY_DONE,
    STUDY_STATUS_CHANGE_LEVEL_2_ANCESTRY_DONE,
    STUDY_STATUS_CHANGE_LEVEL_1_CURATION_DONE,
    STUDY_STATUS_CHANGE_LEVEL_2_CURATION_DONE,
    STUDY_STATUS_CHANGE_PUBLISH_STUDY,
    STUDY_STATUS_CHANGE_AWAITING_CURATION,
    STUDY_STATUS_CHANGE_OUTSTANDING_QUERY,
    STUDY_STATUS_CHANGE_CNV_PAPER,
    STUDY_STATUS_CHANGE_CURATION_ABANDONED,
    STUDY_STATUS_CHANGE_CONVERSION_PROBLEM,
    STUDY_STATUS_CHANGE_UNPUBLISHED_FROM_CATALOG,
    STUDY_STATUS_CHANGE_PENDING_AUTHOR_QUERY,
    STUDY_STATUS_CHANGE_AWAITING_EFO_ASSIGNMENT,
    STUDY_STATUS_CHANGE_UNKNOWN,

    // Curator assignment
    STUDY_CURATOR_ASSIGNMENT_MORALES,
    STUDY_CURATOR_ASSIGNMENT_MACARTHUR,
    STUDY_CURATOR_ASSIGNMENT_HINDORFF,
    STUDY_CURATOR_ASSIGNMENT_JUNKINS,
    STUDY_CURATOR_ASSIGNMENT_HALL,
    STUDY_CURATOR_ASSIGNMENT_WELTER,
    STUDY_CURATOR_ASSIGNMENT_UNASSIGNED,
    STUDY_CURATOR_ASSIGNMENT_GWAS_CATALOG,
    STUDY_CURATOR_ASSIGNMENT_LEVEL_2_CURATOR,
    STUDY_CURATOR_ASSIGNMENT_LEVEL_1_CURATOR,
    STUDY_CURATOR_ASSIGNMENT_LEVEL_1_ETHNICITY_CURATOR,
    STUDY_CURATOR_ASSIGNMENT_CEREZO,
    STUDY_CURATOR_ASSIGNMENT_MILANO,
    STUDY_CURATOR_ASSIGNMENT_MCMAHON,
    STUDY_CURATOR_ASSIGNMENT_UNKNOWN,

    STUDY_FILE_UPLOAD,
    STUDY_UPDATE,
    STUDY_DELETION,
    STUDY_DUPLICATION,
    STUDY_SAMPLE_DESCRIPTION_UPDATE,

    // Association tracking
    ASSOCIATION_CREATION,
    ASSOCIATION_UPDATE,
    ASSOCIATION_MAPPING,
    ASSOCIATION_APPROVED,
    ASSOCIATION_UNAPPROVED,
    ASSOCIATION_DELETION,

    // Ethnicity tracking
    ETHNICITY_CREATED,
    ETHNICITY_UPDATED,
    ETHNICITY_DELETED
}
