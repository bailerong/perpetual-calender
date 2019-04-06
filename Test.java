import java.util.Scanner;
public class Test{
        public static void main(String[] args){
                int year,mouth,day,daynum,XING_QI_JI;
        boolean flag;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份:");
        year = sc.nextInt();
        System.out.println("请输入月份:");
        mouth = sc.nextInt();
        System.out.println("请输入日期:");
        day = sc.nextInt();
        flag=ruiNian(year);
        daynum=thisMouthDayNum(mouth,flag);
        XING_QI_JI=panDuan(year,mouth,day);
        output(year,daynum,XING_QI_JI);
        }
//判断是否为瑞年
public static boolean ruiNian(int year){
        boolean boo;
        if(year%4==0&&year%100!=0||year%400==0){
        boo=true;
        }else
        boo=false;
        return boo;
        }
//判断输入的那个月份有多少天
public static int thisMouthDayNum(int mouth,boolean flag){
        int num;
        if(flag){
        switch(mouth){
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
        num=31;
        return num;
        case 2:
        num=29;
        return num;
        case 4:
        case 6:
        case 9:
        case 11:
        num=30;
        return num;
default :
        System.out.println("您的输入有误!");
        }
        } else{

        switch(mouth){
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
        num=31;
        return num;
        case 2:
        num=28;
        return num;
        case 4:
        case 6:
        case 9:
        case 11:
        num=30;
        return num;
default :
        System.out.println("您的输入有误!");
        }
        }
        return 0;
        }
//判断输入的那天是星期几
public static int panDuanXingQi(int year,int mouth,int day){
        int sum=182,x=0;
        if(year>2017){
        for(int i=2018;i<year;i++){
        if(ruiNian(i)){
        sum=sum+366;
        }
        else{
        sum=sum+365;
        }
        }
        sum=sum+diJiTian(ruiNian(year),mouth,day);
        }
        x=sum%7;
        System.out.println("sum%7余数:"+x);
        return x;
        }
//判断输入的那个月份的1号是星期几,以2017年7月3号为中轴线,7月3号为星期1.
public static int panDuan(int year,int mouth,int day){
        int sum1=182,sum2=183,x=0;
        if(year>2017){
        for(int i=2018;i<year;i++){
        if(ruiNian(i)){
        sum1=sum1+366;
        }
        else{
        sum1=sum1+365;
        }
        }
        sum1=sum1+diJiTian(ruiNian(year),mouth,day)-day+1;
        x=sum1%7;
        }
        else if(year<2017)
        {
        for(int i=2016;i>year;i--){
        if(ruiNian(i)){
        sum2=sum2+366;
        }
        else{
        sum2=sum2+365;
        }
        }
        if(ruiNian(year)){
        sum2=sum2+366-diJiTian(ruiNian(year),mouth,day)+day;
        }
        else{
        sum2=sum2+365-diJiTian(ruiNian(year),mouth,day)+day;
        }
        x=sum2%7;
        }
        else
        {
        if(mouth==1)
        x=0;
        if(mouth==2)
        x=3;
        if(mouth==3)
        x=3;
        if(mouth==4)
        x=6;
        if(mouth==5)
        x=1;
        if(mouth==6)
        x=4;
        if(mouth==7)
        x=6;
        if(mouth==8)
        x=2;
        if(mouth==9)
        x=5;
        if(mouth==10)
        x=0;
        if(mouth==11)
        x=3;
        if(mouth==12)
        x=5;
        }

        return x;
        }
//判断输入的那天是这一年的第几天
public static int diJiTian(boolean flag,int mouth,int day){
        int count;
        if(flag){
        count=0;
        for(int i=1;i<mouth;i++){
        if(i==1|i==3|i==5|i==7|i==8|i==10|i==12){
        count=count+31;
        }else if(i==2){
        count=count+29;
        }else{
        count=count+30;
        }
        }
        count=count+day;
        }
        else
        {
        count=0;
        for(int i=1;i<mouth;i++){
        if(i==1|i==3|i==5|i==7|i==8|i==10|i==12){
        count=count+31;
        }else if(i==2){
        count=count+28;
        }else{
        count=count+30;
        }
        }
        count=count+day;
        }
        return count;
        }

public static void output(int year,int num,int XING_QI_JI){
        int count=0;
        System.out.println("星期日\t"+"星期一\t"+"星期二\t"+"星期三\t"+"星期四\t"+"星期五\t"+"星期六");
        if(year>=2017){
        for(int i=0;i<XING_QI_JI;i++){
        System.out.print("\t");
        }
        for(int i=1;i<=7-XING_QI_JI;i++)
        {
        System.out.print(i+"\t");
        }
        System.out.println();
        for(int i=8-XING_QI_JI;i<=num;i++)
        {
        System.out.print(i+"\t");
        count++;
        if(count%7==0)
        {
        System.out.println();
        }
        }
        }
        else{
        switch(XING_QI_JI)
        {
        case 0:
        {
        System.out.print("\t");
        for(int i=1;i<=6;i++)
        {
        System.out.print(i+"\t");
        }
        System.out.println();
        for(int i=7;i<=num;i++)
        {
        System.out.print(i+"\t");
        count++;
        if(count%7==0)
        {
        System.out.println();
        }
        }
        count=0;
        };
        break;
        case 1:
        {
        for(int i=1;i<=7;i++)
        {
        System.out.print(i+"\t");
        }
        System.out.println();
        for(int i=8;i<=num;i++)
        {
        System.out.print(i+"\t");
        count++;
        if(count%7==0)
        {
        System.out.println();
        }
        }
        count=0;
        };
        break;
        case 2:
        {
        System.out.print("\t\t\t\t\t\t");
        for(int i=1;i<=1;i++)
        {
        System.out.print(i+"\t");
        }
        System.out.println();
        for(int i=2;i<=num;i++)
        {
        System.out.print(i+"\t");
        count++;
        if(count%7==0)
        {
        System.out.println();
        }
        }
        count=0;
        };
        break;
        case 3:
        {
        System.out.print("\t\t\t\t\t");
        for(int i=1;i<=2;i++)
        {
        System.out.print(i+"\t");
        }
        System.out.println();
        for(int i=3;i<=num;i++)
        {
        System.out.print(i+"\t");
        count++;
        if(count%7==0)
        {
        System.out.println();
        }
        }
        count=0;
        };
        break;
        case 4:
        {
        System.out.print("\t\t\t\t");
        for(int i=1;i<=3;i++)
        {
        System.out.print(i+"\t");
        }
        System.out.println();
        for(int i=4;i<=num;i++)
        {
        System.out.print(i+"\t");
        count++;
        if(count%7==0)
        {
        System.out.println();
        }
        }
        count=0;
        };
        break;
        case 5:
        {
        System.out.print("\t\t\t");
        for(int i=1;i<=4;i++)
        {
        System.out.print(i+"\t");
        }
        System.out.println();
        for(int i=5;i<=num;i++)
        {
        System.out.print(i+"\t");
        count++;
        if(count%7==0)
        {
        System.out.println();
        }
        }
        count=0;
        };
        break;
        case 6:
        {
        System.out.print("\t\t");
        for(int i=1;i<=5;i++)
        {
        System.out.print(i+"\t");
        }
        System.out.println();
        for(int i=6;i<=num;i++)
        {
        System.out.print(i+"\t");
        count++;
        if(count%7==0)
        {
        System.out.println();
        }
        }
        count=0;
        };
        break;
        }
        }
        }
        }