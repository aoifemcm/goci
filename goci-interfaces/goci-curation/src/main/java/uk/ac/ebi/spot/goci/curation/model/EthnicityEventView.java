package uk.ac.ebi.spot.goci.curation.model;

import java.util.Date;

/**
 * Created by emma on 05/08/2016.
 *
 * @author emma
 */
public class EthnicityEventView extends EventView {

    private String ethnicitySummary;

    public EthnicityEventView(String event,
                              Date eventDate,
                              Long trackableId,
                              String userEmail,
                              String ethnicitySummary) {
        super(event, eventDate, trackableId, userEmail);
        this.ethnicitySummary = ethnicitySummary;
    }

    public String getEthnicitySummary() {
        return ethnicitySummary;
    }

    public void setEthnicitySummary(String ethnicitySummary) {
        this.ethnicitySummary = ethnicitySummary;
    }
}
