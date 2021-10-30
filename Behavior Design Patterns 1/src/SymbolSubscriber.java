import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber {
    SymbolSubscriber() {
        super();

        String filename = "Symbol.txt";
        Path filePath = Paths.get(System.getProperty("user.dir"), "src",filename);

        this.file = new File(filePath.toString());

    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        ((StringSubscription)subscription).addSubscriber(this);
    }

    @Override
    public void onNext(Object item) {
        if (item.toString().matches("(.*)[^a-zA-z0-9](.*)")) {

            try {


                FileWriter fWriter = new FileWriter(file, true);

                System.out.println("SymbolSubscriber " + " receives : " + item);

                fWriter.write(item + "\n");

                fWriter.flush();
                fWriter.close();



            } catch (IOException  e) {
                System.out.println("Exception: "+e);
            }

        }
    }
}
