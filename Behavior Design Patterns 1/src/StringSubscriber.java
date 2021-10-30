import java.io.File;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber{

    protected File file;

    public abstract void onSubscribe(Flow.Subscription subscription);

    public abstract void onNext(Object item);

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Exception: " + throwable.toString());
    }

    @Override
    public void onComplete() {
        System.out.println("complete");
    }


}
