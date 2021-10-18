package edu.parinya.softarchdesign.structural;
//decorator @override service & getPrice
public abstract class HealthcareWorkerDecorator extends HealthcareWorker{

    protected HealthcareServiceable worker;

    public HealthcareWorkerDecorator(HealthcareWorker worker) {
        super(worker);
        this.worker = worker;
    }

    public double getPrice(){
        return worker.getPrice();
    }

    public void service(){
        this.worker.service();
    }

}
