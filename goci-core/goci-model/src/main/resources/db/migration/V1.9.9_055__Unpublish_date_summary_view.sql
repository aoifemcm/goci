/*

################################################################################
Migration script to add the new UNPUBLISH_DATE TO the CATALOG_SUMMARY_VIEW

Designed for execution with Flyway database migrations tool; this should be
automatically run to completely generate the schema that is out-of-the-box
compatibile with the GOCI model (see
https://github.com/tburdett/goci/tree/2.x-dev/goci-core/goci-model for more).

author:  Dani Welter
date:    June 8th 2015
version: 1.9.9.055 (pre 2.0)
################################################################################
*/

--------------------------------------------------------
--  Regenerate CATALOG_SUMMARY_VIEW
--------------------------------------------------------

CREATE OR REPLACE VIEW CATALOG_SUMMARY_VIEW (
  ID,
  STUDY_ADDED_DATE,
  PUBMED_ID,
  AUTHOR,
  PUBLICATION_DATE,
  JOURNAL,
  LINK,
  STUDY,
  DISEASE_TRAIT,
  EFO_TRAIT,
  EFO_URI,
  INITIAL_SAMPLE_DESCRIPTION,
  REPLICATE_SAMPLE_DESCRIPTION,
  REGION,
  CHROMOSOME_NAME,
  CHROMOSOME_POSITION,
  REPORTED_GENE,
  MAPPED_GENE,
  ENTREZ_GENE_ID,
  UPSTREAM_MAPPED_GENE,
  UPSTREAM_ENTREZ_GENE_ID,
  UPSTREAM_GENE_DISTANCE,
  DOWNSTREAM_MAPPED_GENE,
  DOWNSTREAM_ENTREZ_GENE_ID,
  DOWNSTREAM_GENE_DISTANCE,
  STRONGEST_SNP_RISK_ALLELE,
  SNP_RSID,
  MERGED,
  SNP_ID,
  CONTEXT,
  IS_INTERGENIC,
  RISK_ALLELE_FREQUENCY,
  P_VALUE_MANTISSA,
  P_VALUE_EXPONENT,
  P_VALUE_QUALIFIER,
  OR_BETA,
  CI,
  CI_QUALIFIER,
  PLATFORM,
  CNV,
  ASSOCIATION_ID,
  STUDY_ID,
  CATALOG_PUBLISH_DATE,
  CATALOG_UNPUBLISH_DATE,
  CURATION_STATUS)
  AS SELECT ROWNUM, V.* FROM
  (SELECT
  h.STUDY_ADDED_DATE,
  s.PUBMED_ID,
  s.AUTHOR,
  s.PUBLICATION_DATE,
  s.PUBLICATION AS JOURNAL,
  CONCAT('http://europepmc.org/abstract/MED/', s.PUBMED_ID) AS LINK,
  s.TITLE AS STUDY,
  dt.TRAIT AS DISEASE_TRAIT,
  et.TRAIT AS EFO_TRAIT,
  et.URI AS EFO_URI,
  s.INITIAL_SAMPLE_SIZE AS INITIAL_SAMPLE_DESCRIPTION,
  s.REPLICATE_SAMPLE_SIZE AS REPLICATE_SAMPLE_DESCRIPTION,
  r.NAME AS REGION,
  snp.CHROMOSOME_NAME,
  snp.CHROMOSOME_POSITION,
  rg.GENE_NAME AS REPORTED_GENE,
  img.GENE_NAME AS MAPPED_GENE,
  img.ENTREZ_GENE_ID,
  umg.GENE_NAME AS UPSTREAM_MAPPED_GENE,
  umg.ENTREZ_GENE_ID AS UPSTREAM_ENTREZ_GENE_ID,
  ugc.DISTANCE AS UPSTREAM_GENE_DISTANCE,
  dmg.GENE_NAME AS DOWNSTREAM_MAPPED_GENE,
  dmg.ENTREZ_GENE_ID AS DOWNSTREAM_ENTREZ_GENE_ID,
  dgc.DISTANCE AS DOWNSTREAM_GENE_DISTANCE,
  ra.RISK_ALLELE_NAME AS STRONGEST_SNP_RISK_ALLELE,
  snp.RS_ID AS SNP_RS_ID,
  snp.MERGED,
  snp.ID AS SNP_ID,
  snp.FUNCTIONAL_CLASS AS CONTEXT,
  (CASE WHEN igc.IS_INTERGENIC IS NOT NULL THEN igc.IS_INTERGENIC ELSE ugc.IS_INTERGENIC END) AS IS_INTERGENIC,
  a.RISK_FREQUENCY AS RISK_ALLELE_FREQUENCY,
  a.PVALUE_MANTISSA AS P_VALUE_MANTISSA,
  a.PVALUE_EXPONENT AS P_VALUE_EXPONENT,
  a.PVALUE_TEXT AS P_VALUE_QUALIFIER,
  a.OR_PER_COPY_NUM AS OR_BETA,
  a.OR_PER_COPY_RANGE AS CI,
  a.OR_PER_COPY_UNIT_DESCR AS CI_QUALIFIER,
  s.PLATFORM,
  s.CNV,
  a.ID AS ASSOCIATION_ID,
  s.ID AS STUDY_ID,
  h.CATALOG_PUBLISH_DATE,
  h.CATALOG_UNPUBLISH_DATE,
  cs.STATUS as CURATION_STATUS
  FROM STUDY s
  JOIN HOUSEKEEPING h ON h.ID = s.HOUSEKEEPING_ID
  JOIN CURATION_STATUS cs ON h.CURATION_STATUS_ID = cs.ID
  LEFT JOIN STUDY_DISEASE_TRAIT sdt ON sdt.STUDY_ID = s.ID
  LEFT JOIN DISEASE_TRAIT dt ON dt.ID = sdt.DISEASE_TRAIT_ID
  LEFT JOIN STUDY_EFO_TRAIT seft ON seft.STUDY_ID = s.ID
  LEFT JOIN EFO_TRAIT et ON et.ID = seft.EFO_TRAIT_ID
  LEFT JOIN ASSOCIATION a ON a.STUDY_ID = s.ID
  LEFT JOIN ASSOCIATION_LOCUS al ON al.ASSOCIATION_ID = a.ID
  LEFT JOIN LOCUS_RISK_ALLELE lra ON lra.LOCUS_ID = al.LOCUS_ID
  LEFT JOIN RISK_ALLELE ra ON ra.ID = lra.RISK_ALLELE_ID
  LEFT JOIN RISK_ALLELE_SNP ras ON ras.RISK_ALLELE_ID = lra.RISK_ALLELE_ID
  LEFT JOIN SINGLE_NUCLEOTIDE_POLYMORPHISM snp ON snp.ID = ras.SNP_ID
  LEFT JOIN SNP_REGION sr ON sr.SNP_ID = snp.ID
  LEFT JOIN REGION r ON r.ID = sr.REGION_ID
  LEFT JOIN AUTHOR_REPORTED_GENE arg ON arg.LOCUS_ID = al.LOCUS_ID
  LEFT JOIN GENE rg ON rg.ID = arg.REPORTED_GENE_ID
  LEFT JOIN GENOMIC_CONTEXT ugc ON ugc.SNP_ID = snp.ID AND ugc.IS_UPSTREAM = '1'
  LEFT JOIN GENOMIC_CONTEXT dgc ON dgc.SNP_ID = snp.ID AND dgc.IS_DOWNSTREAM = '1'
  LEFT JOIN GENOMIC_CONTEXT igc ON igc.SNP_ID = snp.ID AND igc.IS_INTERGENIC = '0'
  LEFT JOIN GENE umg ON umg.ID = ugc.GENE_ID
  LEFT JOIN GENE dmg ON dmg.ID = dgc.GENE_ID
  LEFT JOIN GENE img ON img.ID = igc.GENE_ID
  ORDER BY s.PUBLICATION_DATE DESC, CHROMOSOME_NAME ASC, CHROMOSOME_POSITION ASC) V