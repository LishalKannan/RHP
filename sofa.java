import java.io.*;
import java.util.*;
class sofa{
    int fsr,fsc,ssr,ssc;
    char dir;
    int moves;
    public sofa(int fsr,int fsc,int ssr,int ssc,char d,int m){
        this.fsr=fsr;
        this.fsc=fsc;
        this.ssr=ssr;
        this.ssc=ssc;
        this.dir = d;
        this.moves = m;
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        sc.nextLine();
        int fsr,fsc,ssr,ssc,sofa_count=0;
        fsr=fsc=ssr=ssc=-1;
        char[][] house=new char[r][c];
        Queue<sofa> q=new LinkedList<>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                char ch=sc.next().charAt(0);
                house[i][j]=ch;
                if(ch=='s'){
                    sofa_count++;
                    if(sofa_count==1){
                        fsr=i;
                        fsc=j;
                    }
                    else if(sofa_count==2){
                        ssr=i;
                        ssc=j;
                        sofa s=new sofa(fsr,fsc,ssr,ssc,(fsr==ssr)?'H':'V',0);
                        q.add(s);
                    }
                }
            }
        }
        Set<String> vis=new HashSet<>();
        if(fsr!=-1 && ssr!=-1){
            canAdd(fsr,fsc,ssr,ssc,vis);
        }
        while(!q.isEmpty()){
            sofa s=q.poll();
            if(house[s.fsr][s.fsc]=='S' && house[s.ssr][s.ssc]=='S'){
                System.out.println(s.moves); return;
            }
            if(s.dir=='H'){
                if(s.ssc<c-1 && house[s.ssr][s.ssc+1]!='H'){
                    if(canAdd(s.fsr,s.fsc+1,s.ssr,s.ssc+1,vis)){
                        q.add(new sofa(s.fsr,s.fsc+1,s.ssr,s.ssc+1,'H',s.moves+1));
                    }
                }
                if(s.fsc>0 && house[s.fsr][s.fsc-1]!='H'){
                    if(canAdd(s.fsr,s.fsc-1,s.ssr,s.ssc-1,vis)){
                        q.add(new sofa(s.fsr,s.fsc-1,s.ssr,s.ssc-1,'H',s.moves+1));
                    }
                }
                if(s.fsr>0 && house[s.fsr-1][s.fsc]!='H' && house[s.ssr-1][s.ssc]!='H'){
                    if(canAdd(s.fsr-1,s.fsc,s.ssr-1,s.ssc,vis)){
                        q.add(new sofa(s.fsr-1,s.fsc,s.ssr-1,s.ssc,'H',s.moves+1));
                    }
                }
                if(s.fsr<r-1 && house[s.fsr+1][s.fsc]!='H' && house[s.ssr+1][s.ssc]!='H'){
                    if(canAdd(s.fsr+1,s.fsc,s.ssr+1,s.ssc,vis)){
                        q.add(new sofa(s.fsr+1,s.fsc,s.ssr+1,s.ssc,'H',s.moves+1));
                    }
                }
                if(s.fsr>0 && house[s.fsr-1][s.fsc]!='H' && house[s.fsr-1][s.fsc+1]!='H'){
                    if(canAdd(s.fsr,s.fsc,s.fsr-1,s.fsc,vis)){
                        q.add(new sofa(s.fsr,s.fsc,s.fsr-1,s.fsc,'V',s.moves+1));
                    }
                    if(canAdd(s.fsr,s.fsc+1,s.fsr-1,s.fsc+1,vis)){
                        q.add(new sofa(s.fsr,s.fsc+1,s.fsr-1,s.fsc+1,'V',s.moves+1));
                    }
                }
                if(s.fsr<r-1 && house[s.fsr+1][s.fsc]!='H' && house[s.fsr+1][s.fsc+1]!='H'){
                    if(canAdd(s.fsr,s.fsc,s.fsr+1,s.fsc,vis)){
                        q.add(new sofa(s.fsr,s.fsc,s.fsr+1,s.fsc,'V',s.moves+1));
                    }
                    if(canAdd(s.fsr,s.fsc+1,s.fsr+1,s.fsc+1,vis)){
                        q.add(new sofa(s.fsr,s.fsc+1,s.fsr+1,s.fsc+1,'V',s.moves+1));
                    }
                }
            }
            else{
                if(s.fsr>0 && house[s.fsr-1][s.fsc]!='H' && house[s.ssr-1][s.ssc]!='H'){
                    if(canAdd(s.fsr-1,s.fsc,s.ssr-1,s.ssc,vis)){
                        q.add(new sofa(s.fsr-1,s.fsc,s.ssr-1,s.ssc,'V',s.moves+1));
                    }
                }
                if(s.fsr<r-1 && house[s.fsr+1][s.fsc]!='H' && house[s.ssr+1][s.ssc]!='H'){
                    if(canAdd(s.fsr+1,s.fsc,s.ssr+1,s.ssc,vis)){
                        q.add(new sofa(s.fsr+1,s.fsc,s.ssr+1,s.ssc,'V',s.moves+1));
                    }
                }
                if(s.fsc>0 && house[s.fsr][s.fsc-1]!='H' && house[s.ssr][s.ssc-1]!='H'){
                    if(canAdd(s.fsr,s.fsc-1,s.ssr,s.ssc-1,vis)){
                        q.add(new sofa(s.fsr,s.fsc-1,s.ssr,s.ssc-1,'V',s.moves+1));
                    }
                }
                if(s.fsc<c-1 && house[s.fsr][s.fsc+1]!='H' && house[s.ssr][s.ssc+1]!='H'){
                    if(canAdd(s.fsr,s.fsc+1,s.ssr,s.ssc+1,vis)){
                        q.add(new sofa(s.fsr,s.fsc+1,s.ssr,s.ssc+1,'V',s.moves+1));
                    }
                }
                if(s.fsr>0 && s.fsc>0 && house[s.fsr-1][s.fsc-1]!='H' && house[s.fsr-1][s.fsc]!='H' && house[s.fsr][s.fsc-1]!='H'){
                    if(canAdd(s.fsr-1,s.fsc-1,s.fsr-1,s.fsc,vis)){
                        q.add(new sofa(s.fsr-1,s.fsc-1,s.fsr-1,s.fsc,'H',s.moves+1));
                    }
                }
                if(s.fsr>0 && s.fsc<c-1 && house[s.fsr-1][s.fsc]!='H' && house[s.fsr-1][s.fsc+1]!='H' && house[s.fsr][s.fsc+1]!='H'){
                    if(canAdd(s.fsr-1,s.fsc,s.fsr-1,s.fsc+1,vis)){
                        q.add(new sofa(s.fsr-1,s.fsc,s.fsr-1,s.fsc+1,'H',s.moves+1));
                    }
                }
                if(s.fsr<r-1 && s.fsc>0 && house[s.fsr+1][s.fsc-1]!='H' && house[s.fsr+1][s.fsc]!='H' && house[s.fsr][s.fsc-1]!='H'){
                    if(canAdd(s.fsr+1,s.fsc-1,s.fsr+1,s.fsc,vis)){
                        q.add(new sofa(s.fsr+1,s.fsc-1,s.fsr+1,s.fsc,'H',s.moves+1));
                    }
                }
                if(s.fsr<r-1 && s.fsc<c-1 && house[s.fsr+1][s.fsc]!='H' && house[s.fsr+1][s.fsc+1]!='H' && house[s.fsr][s.fsc+1]!='H'){
                    if(canAdd(s.fsr+1,s.fsc,s.fsr+1,s.fsc+1,vis)){
                        q.add(new sofa(s.fsr+1,s.fsc,s.fsr+1,s.fsc+1,'H',s.moves+1));
                    }
                }
            }
        }
        System.out.println("Impossible");
        sc.close();
    }
    static final String DELIM="-";
    private static boolean canAdd(int fsr,int fsc,int ssr,int ssc,Set<String>vis){
        StringBuilder sb=new StringBuilder();
        sb.append(fsr).append(DELIM).append(fsc).append(DELIM).append(ssr).append(DELIM).append(ssc);
        String key=sb.toString();
        if(vis.contains(key)){
            return false;
        }
        vis.add(key);
        return true;

    }
}
