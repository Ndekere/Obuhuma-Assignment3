package employees;

public class Salary {
    public double nhif;
    public double nssf;
    public double payee;
    public double grosspay;
    public double netpay;
    public void Gross(double basicsalary,double houseallowance){
    grosspay=basicsalary+houseallowance;
    }
//settters
    public void Nhif(double basicsalary){
    if(basicsalary>100000){
    nhif=1200;
    }
    else {
    nhif=320;
    }
    }
    public void Nssf(){
    nssf=200;
    }
    public void Payee(double grosspay){
    payee=0.3*grosspay;
    }
    public void Netpay(double grosspay){
    netpay=grosspay-(nhif+nssf);
    }
    
    
    //Gettters

    public double setNetpay() {
        return netpay;
    }

   
    public double setGross(){
    return grosspay;    
    }
    public double setNhif(){
    return nhif;
    }
    public double setNssf(){
    return nssf;
    }
    public double setPayee(){
    return payee;
    }
}
