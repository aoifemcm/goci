package uk.ac.ebi.spot.goci.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;


/**
 * Created by emma on 03/12/14.
 *
 * @author emma
 *         <p>
 *         Model representing housekeeping information stored about a study that is used during curation
 */
@Entity
public class Housekeeping {
    @Id
    @GeneratedValue
    private Long id;

    private Boolean studySnpCheckedLevelOne = false;

    private Boolean studySnpCheckedLevelTwo = false;

    private Boolean ethnicityCheckedLevelOne = false;

    private Boolean ethnicityCheckedLevelTwo = false;

    private Boolean ethnicityBackFilled = false;

    private Boolean checkedMappingError = false;

    private Boolean snpsRechecked = false;

    private Boolean isPublished = false;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date catalogPublishDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sendToNCBIDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date studyAddedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date catalogUnpublishDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateDate;

    private String fileName;

    private String notes;

    @OneToOne
    private Curator curator;

    @OneToOne
    private CurationStatus curationStatus;

    @OneToOne
    private UnpublishReason unpublishReason;

    // JPA no-args constructor
    public Housekeeping() {
    }

    public Housekeeping(Boolean studySnpCheckedLevelOne,
                        Boolean studySnpCheckedLevelTwo,
                        Boolean ethnicityCheckedLevelOne,
                        Boolean ethnicityCheckedLevelTwo,
                        Boolean ethnicityBackFilled,
                        Boolean checkedMappingError,
                        Boolean snpsRechecked,
                        Boolean isPublished,
                        Date catalogPublishDate,
                        Date sendToNCBIDate,
                        Date studyAddedDate,
                        Date catalogUnpublishDate,
                        Date lastUpdateDate,
                        String fileName,
                        String notes,
                        Curator curator,
                        CurationStatus curationStatus,
                        UnpublishReason unpublishReason) {
        this.studySnpCheckedLevelOne = studySnpCheckedLevelOne;
        this.studySnpCheckedLevelTwo = studySnpCheckedLevelTwo;
        this.ethnicityCheckedLevelOne = ethnicityCheckedLevelOne;
        this.ethnicityCheckedLevelTwo = ethnicityCheckedLevelTwo;
        this.ethnicityBackFilled = ethnicityBackFilled;
        this.checkedMappingError = checkedMappingError;
        this.snpsRechecked = snpsRechecked;
        this.isPublished = isPublished;
        this.catalogPublishDate = catalogPublishDate;
        this.sendToNCBIDate = sendToNCBIDate;
        this.studyAddedDate = studyAddedDate;
        this.catalogUnpublishDate = catalogUnpublishDate;
        this.lastUpdateDate = lastUpdateDate;
        this.fileName = fileName;
        this.notes = notes;
        this.curator = curator;
        this.curationStatus = curationStatus;
        this.unpublishReason = unpublishReason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStudySnpCheckedLevelOne() {
        return studySnpCheckedLevelOne;
    }

    public void setStudySnpCheckedLevelOne(Boolean studySnpCheckedLevelOne) {
        this.studySnpCheckedLevelOne = studySnpCheckedLevelOne;
    }

    public Boolean getStudySnpCheckedLevelTwo() {
        return studySnpCheckedLevelTwo;
    }

    public void setStudySnpCheckedLevelTwo(Boolean studySnpCheckedLevelTwo) {
        this.studySnpCheckedLevelTwo = studySnpCheckedLevelTwo;
    }

    public Boolean getEthnicityCheckedLevelOne() {
        return ethnicityCheckedLevelOne;
    }

    public void setEthnicityCheckedLevelOne(Boolean ethnicityCheckedLevelOne) {
        this.ethnicityCheckedLevelOne = ethnicityCheckedLevelOne;
    }

    public Boolean getEthnicityCheckedLevelTwo() {
        return ethnicityCheckedLevelTwo;
    }

    public void setEthnicityCheckedLevelTwo(Boolean ethnicityCheckedLevelTwo) {
        this.ethnicityCheckedLevelTwo = ethnicityCheckedLevelTwo;
    }

    public Boolean getEthnicityBackFilled() {
        return ethnicityBackFilled;
    }

    public void setEthnicityBackFilled(Boolean ethnicityBackFilled) {
        this.ethnicityBackFilled = ethnicityBackFilled;
    }

    public Boolean getCheckedMappingError() {
        return checkedMappingError;
    }

    public void setCheckedMappingError(Boolean checkedMappingError) {
        this.checkedMappingError = checkedMappingError;
    }

    public Boolean getSnpsRechecked() {
        return snpsRechecked;
    }

    public void setSnpsRechecked(Boolean snpsRechecked) {
        this.snpsRechecked = snpsRechecked;
    }

    public Date getCatalogPublishDate() {
        return catalogPublishDate;
    }

    public void setCatalogPublishDate(Date catalogPublishDate) {
        this.catalogPublishDate = catalogPublishDate;
    }

    public Date getSendToNCBIDate() {
        return sendToNCBIDate;
    }

    public void setSendToNCBIDate(Date sendToNCBIDate) {
        this.sendToNCBIDate = sendToNCBIDate;
    }

    public Date getStudyAddedDate() {
        return studyAddedDate;
    }

    public void setStudyAddedDate(Date studyAddedDate) {
        this.studyAddedDate = studyAddedDate;
    }

    public Date getCatalogUnpublishDate() {
        return catalogUnpublishDate;
    }

    public void setCatalogUnpublishDate(Date catalogUnpublishDate) {
        this.catalogUnpublishDate = catalogUnpublishDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Curator getCurator() {
        return curator;
    }

    public void setCurator(Curator curator) {
        this.curator = curator;
    }

    public CurationStatus getCurationStatus() {
        return curationStatus;
    }

    public void setCurationStatus(CurationStatus curationStatus) {
        this.curationStatus = curationStatus;
    }

    public UnpublishReason getUnpublishReason() {
        return unpublishReason;
    }

    public void setUnpublishReason(UnpublishReason unpublishReason) {
        this.unpublishReason = unpublishReason;
    }

    public Boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(Boolean published) {
        isPublished = published;
    }
}
