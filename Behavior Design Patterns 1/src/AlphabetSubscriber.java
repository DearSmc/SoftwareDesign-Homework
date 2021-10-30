import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Flow;

public class AlphabetSubscriber extends StringSubscriber {
    public AlphabetSubscriber() {
        super();

        String filename = "Alphabet.txt";
        Path filePath = Paths.get(System.getProperty("user.dir"), "src",filename);

        this.file = new File(filePath.toString());

    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        ((StringSubscription)subscription).addSubscriber(this);
    }

    @Override
    public void onNext(Object item) {
        if (item.toString().matches("(.*)[a-zA-z](.*)")) {

            try {
              FileWriter fWriter = new FileWriter(file, true);

                System.out.println("AlphabetSubscriber " + " receives : " + item);

                fWriter.write( item + "\n");

                fWriter.flush();
                fWriter.close();


            }  catch (IOException e) {
                System.out.println("Exception: "+e);
            }

        }
    }
}
