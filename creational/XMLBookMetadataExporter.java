package creational;

import javax.xml.parsers.ParserConfigurationException;

public class XMLBookMetadataExporter extends BookMetadataExporter {

    protected BookMetadataFormatter createFormatter() throws ParserConfigurationException {
        return new XMLBookMetadataFormatter();
    }
}
