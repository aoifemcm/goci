package uk.ac.ebi.spot.goci.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * Javadocs go here!
 *
 * @author Tony Burdett
 * @date 12/02/15
 */
@Entity
public class AssociationReport {
    @Id
    @GeneratedValue
    private Long id;

    private Date lastUpdateDate;

    private String snpError;

    private String snpGeneOnDiffChr;

    private String noGeneForSymbol;

    private String restServiceError;

    private String suspectVariationError;

    private Boolean errorCheckedByCurator = false;

    @OneToOne
    private Association association;

    // JPA no-args constructor
    public AssociationReport() {
    }

    public AssociationReport(Date lastUpdateDate,
                             String snpError,
                             String snpGeneOnDiffChr,
                             String noGeneForSymbol,
                             String restServiceError,
                             String suspectVariationError,
                             Boolean errorCheckedByCurator, Association association) {
        this.lastUpdateDate = lastUpdateDate;
        this.snpError = snpError;
        this.snpGeneOnDiffChr = snpGeneOnDiffChr;
        this.noGeneForSymbol = noGeneForSymbol;
        this.restServiceError = restServiceError;
        this.suspectVariationError = suspectVariationError;
        this.errorCheckedByCurator = errorCheckedByCurator;
        this.association = association;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getSnpError() {
        return snpError;
    }

    public void setSnpError(String snpError) {
        this.snpError = snpError;
    }

    public String getSnpGeneOnDiffChr() {
        return snpGeneOnDiffChr;
    }

    public void setSnpGeneOnDiffChr(String snpGeneOnDiffChr) {
        this.snpGeneOnDiffChr = snpGeneOnDiffChr;
    }

    public String getNoGeneForSymbol() {
        return noGeneForSymbol;
    }

    public void setNoGeneForSymbol(String noGeneForSymbol) {
        this.noGeneForSymbol = noGeneForSymbol;
    }

    public String getRestServiceError() {
        return restServiceError;
    }

    public void setRestServiceError(String restServiceError) {
        this.restServiceError = restServiceError;
    }

    public String getSuspectVariationError() {
        return suspectVariationError;
    }

    public void setSuspectVariationError(String suspectVariationError) {
        this.suspectVariationError = suspectVariationError;
    }

    public Boolean getErrorCheckedByCurator() {
        return errorCheckedByCurator;
    }

    public void setErrorCheckedByCurator(Boolean errorCheckedByCurator) {
        this.errorCheckedByCurator = errorCheckedByCurator;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
