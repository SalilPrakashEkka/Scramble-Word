
/**
 * Write a description of class scribble here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class scramble
{
    public static void main(String[] args)
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the word to be scrambled");
        String mw=ob.next();
        int mwl=mw.length();int sno=1;
        for(int i=1;i<=mwl;i++)//to Calculate the no of permutation
        sno*=i;
        String arr[]=new String[sno];
        int ii3=0;
        if(mwl==3)
        for(int i3=0;i3<3;i3++)
        {
            arr[ii3]=mw;
            //System.out.println(mw);
            ii3++;
            arr[ii3]=(String.valueOf(mw.charAt(0))+String.valueOf(mw.charAt(2))+String.valueOf(mw.charAt(1)));
            //System.out.println(String.valueOf(mw.charAt(0))+String.valueOf(mw.charAt(2))+String.valueOf(mw.charAt(1)));
            //System.out.println("arr[]="+arr[ii3]);
            //System.out.println("ii3="+ii3);
            ii3++;
            mw=reverse(mw,0);
        }
        else
        {
            String tw=mw;int wp=0,po=0,fa=0;
            for(int ib=0;ib<mwl-2;ib++)
            {
                wp=0;
                fa=1;
                po=0;
                tw=mw;
                for(int i=0;i<ib;i++)
                tw=reverse(tw,0);
                //System.out.println("tw="+tw);
                for(int i=1;i<(mwl-ib);i++)//to Calculate the no of permutation
                   fa*=i;
                   //System.out.println("fa="+fa);
                for(int i1=0;i1<sno;i1++)
                {
                    if(arr[i1]!=null)
                    arr[i1]=arr[i1]+String.valueOf(tw.charAt(wp));
                    else
                    arr[i1]=String.valueOf(tw.charAt(wp));
                    //System.out.println("arr["+i1+"]="+arr[i1]);
                    
                    po++;
                    
                    //System.out.println("po="+po);
                    if(po==fa)
                    {
                        wp++;po=0;
                    }
                    if(wp==tw.length()&&i1!=sno-1)
                    {
                        tw=reverse(tw,0);wp=0;
                    }
                }
            }
            tw=mw.substring(mw.length()-2,mw.length());
            ii3=0;
            
            for(int i=0;i<sno/2;i++)
            {
                //System.out.println("tw="+tw);
                //System.out.println("ii3="+ii3);
                arr[ii3]=arr[ii3]+tw;
                //System.out.println("arr["+ii3+"]="+arr[ii3]);
                ii3++;
                //System.out.println("ii3="+ii3);
                //System.out.println("arr["+ii3+"] 1 ="+String.valueOf(arr[ii3-1].charAt(arr[ii3-1].length()-2)));
                //System.out.println("arr["+ii3+"] 2 ="+String.valueOf(arr[ii3-1].charAt(arr[ii3-1].length()-1)));
                arr[ii3]=arr[ii3]+String.valueOf(arr[ii3-1].charAt(arr[ii3-1].length()-1))+String.valueOf(arr[ii3-1].charAt(arr[ii3-1].length()-2));
                //System.out.println("arr["+ii3+"]="+arr[ii3]);
                tw=arr[ii3].substring(arr[ii3].length()-3,arr[ii3].length()-1);
                tw=String.valueOf(tw.charAt(1))+String.valueOf(tw.charAt(0));
                ii3++;
            }
        }
        for(int p=0;p<sno;p++)
        {
            System.out.println(p+1+":"+arr[p]);
        }
    }
    static String reverse(String w,int s)
    {
        String a="";
        if(s==0)
        a=w.substring(s+1,w.length())+w.charAt(0);
        else
        {
            a=w.substring(0,s)+w.substring(s+1,w.length())+w.charAt(s);
        }
        return a;
    }
}
