package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    public void export(PrintStream stream) throws ParserConfigurationException, IOException{
        BookMetadataFormatter formatter  = createFormatter();
        for(Book book:books){
            formatter.append(book);
        }
        stream.print(formatter.getMetadataString());
    }

    protected abstract BookMetadataFormatter createFormatter() throws ParserConfigurationException, IOException;

}
