import java.util.*;

public class Main{
    public static int n;

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Main ob=new Main();
        
        String data,data_copy,zero="0000000000000000",ans,data_r;
        System.out.print("Enter the data to be transferred:");
        data=in.nextLine();
        data_copy=data;
        data+=zero;
        n=data_copy.length();
        
        System.out.println("Divisor:10001000000100001");

        System.out.println("Modified poly: "+data);
        data=ob.divide(data);

        System.out.println("CheckSum: "+data.substring(n));
        data_copy=data_copy.substring(0,n)+data.substring(n);
        System.out.println("Final Codeword: "+data_copy);
        
        System.out.print("Enter the data received at the destination:");
        data_r=in.nextLine();
        data_r=ob.divide(data_r);
        System.out.println("Remainder:"+data_r);
        
        zero="00000000000000000000000";
        if(data_r.equals(zero)==true){
            System.out.println("No error");
        }
        else{
            System.out.println("Error detected");
        }
    }

    public String divide(String s){
        int i,j;
        char x;
        String div="10001000000100001";

        for(i=0;i<n;i++){
            x=s.charAt(i);

            for(j=0;j<17;j++){
                if(x=='1'){
                    if(s.charAt(i+j)!=div.charAt(j))
                        s=s.substring(0,i+j)+"1"+s.substring(i+j+1);
                    else
                        s=s.substring(0,i+j)+"0"+s.substring(i+j+1);
                }
            }
        }

        return s;
    }
}
