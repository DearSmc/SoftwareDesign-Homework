import java.util.concurrent.Flow;

public class StringPublisher implements Flow.Publisher{

    private static int numberOfSubscriber=0;
    private static StringSubscription subscription;
    
    StringPublisher(){
        this.subscription = new StringSubscription();
    }
    
    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        if(this.numberOfSubscriber < 3)
        {
            subscriber.onSubscribe(this.subscription);
            this.numberOfSubscriber++;
        }
        else{
            subscriber.onError(new IllegalStateException());
        }
    }
    
    public void publish(String text){
        System.out.println("in publisher: "+text);
        subscription.newPublish(text);
    }
}
