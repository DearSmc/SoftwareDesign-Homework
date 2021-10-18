package edu.parinya.softarchdesign.structural;

public class HealthcareWorkerTeam {
    private HealthcareWorker[] memberTeam;
    private int numberOfMembers;

    HealthcareWorkerTeam(){
        this.memberTeam = new HealthcareWorker[50];
        this.numberOfMembers = 0;
    }

    public void addMember(HealthcareWorker member)
    {
        this.memberTeam[this.numberOfMembers] = member;
        this.numberOfMembers++;
    }

    public void addMember(HealthcareWorkerTeam team)
    {
        HealthcareWorker[] members = team.getMemberTeam();
        for(int i=0; i<team.getNumberOfMembers(); i++) {
            this.memberTeam[this.numberOfMembers] = members[i];
            this.numberOfMembers++;
        }
    }

    public void service(){
        for(int i=0; i<this.numberOfMembers; i++)
        {
            this.memberTeam[i].service();
        }
    }

    public double getPrice(){
        double summaryPrice = 0;
        for(int i=0; i<this.numberOfMembers; i++)
        {
            summaryPrice += this.memberTeam[i].getPrice();
        }
        return summaryPrice;
    }

    public void removeMember(HealthcareWorker member){
        HealthcareWorker[] temp = new HealthcareWorker[50];
        int j =0;
        for(int i=0; i<this.numberOfMembers; i++)
        {
            //or use -> this.memberTeam[i].getName() != member.getName()
            if(!(this.memberTeam[i].getName()).equals(member.getName())) {
                temp[j] = memberTeam[i];
                j++;
            }
        }
        this.memberTeam = temp;
        this.numberOfMembers = j;
    }
    public void printAllMember(){
        System.out.println("============ member ===========");
        for(int i=0; i<this.numberOfMembers; i++)
        {
            System.out.println("-> "+this.memberTeam[i].getName());

        }
        System.out.println("================================");

    }

    public int getNumberOfMembers(){
        return this.numberOfMembers;
    }

    public HealthcareWorker[] getMemberTeam(){
        return this.memberTeam;
    }
}
