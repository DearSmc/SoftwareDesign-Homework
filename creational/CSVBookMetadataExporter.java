package creational;

import java.io.IOException;

public class CSVBookMetadataExporter extends BookMetadataExporter {

    protected BookMetadataFormatter createFormatter() throws IOException {
        return new CSVBookMetadataFormatter();
    }
}

