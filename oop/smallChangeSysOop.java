package smallChangeSys.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*该类完成零钱通的各个功能的类
使用OOP的方式
将各个功能对应一个方法
* */
public class smallChangeSysOop {
    Scanner scanner = new Scanner(System.in);
    boolean loop = true;
    //2-完成零钱通明细
    //2.1使用数组 2-2 使用对象 2-3 使用字符串拼接
    String detail = "---------零钱通明细-----------";
    //3-完成收益入账
    //功能驱动增加新的变量和代码
    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");//可以用于日期格式化的对象
    //4-消费
    //定义新变量：消费的原因
    String note = "";
    //显示主菜单
    public void mainMenu(){
        do {
            System.out.println("==========零钱通菜单==========");
            System.out.println("\t\t1-零钱通明细");
            System.out.println("\t\t2-收益入账");
            System.out.println("\t\t3-消  费");
            System.out.println("\t\t4-退  出");
            System.out.println("请选择1-4：");
            int s = scanner.nextInt();
            switch (s) {
                case 1:
                    this.detail();
                    break;
                case 2:
                    this.income();
                    break;
                case 3:
                    this.pay();
                    break;
                case 4:
                   this.exit();
                    break;
                default:
                    System.out.println("请重新输入：");
            }
        }
        while (loop);
    }
    //显示零钱通过明细
    public void detail(){
        System.out.println(detail);
    }
    //完成收益入账
    public void income(){
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();
        //money的值应该校验——先完成主功能，再进行完善
        //找出不正确的金额条件，然后return
        if(money <= 0){
            System.out.println("收益金额应该大于0");
            return;//退出方法 不再执行后面方法
        }
        balance += money;
        //拼接收益入账信息 details
        date = new Date();//获取当前日期
        detail += "\n收益入账" + "\t" + money + "\t" + sdf.format(date) + "\t" + balance;
    }
    //完成消费
    public void pay(){
        System.out.println("消费金额");
        money = scanner.nextDouble();
        //money的范围的校验
        if(money <= 0 || money>balance){
            System.out.println("消费金额应该在0-"+balance);
            return;
        }
        System.out.println("消费说明：");
        note = scanner.next();
        balance -= money;
        //拼接消费入账信息 details
        date = new Date();//获取当前日期
        detail += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }
    //退出
    public void exit(){
        String choice = "";
        while (true) {//要求用户必须输入y/n
            System.out.println("你确定要退出吗?y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }
        //当用户退出
        if (choice.equals("y")) {
            loop = false;
        }
    }

}
