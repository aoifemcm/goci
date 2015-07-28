package uk.ac.ebi.spot.goci.sparql.pussycat.renderlet.chromosome;

import net.sourceforge.fluxion.spi.ServiceProvider;
import uk.ac.ebi.spot.goci.ontology.OntologyConstants;

import java.net.URI;
import java.net.URL;

/**
 * Created by IntelliJ IDEA. User: dwelter Date: 01/03/12 Time: 10:46 To change this template use File | Settings | File
 * Templates.
 */

@ServiceProvider
public class SparqlChromosomeSeventeenRenderlet extends SparqlChromosomeRenderlet {
    private URI chromosomeURI = URI.create(OntologyConstants.GWAS_ONTOLOGY_BASE_IRI + "/Chromosome/17");
    private int position = 16;

    @Override public String getName() {
        return "Chromosome 17";
    }

    @Override
    protected URL getSVGFile() {
        return getClass().getClassLoader().getResource("chromosomes/17.svg");
    }

    @Override
    protected URI getChromosomeURI() {
        return chromosomeURI;
    }

    @Override
    protected int getPosition() {
        return position;
    }
}
