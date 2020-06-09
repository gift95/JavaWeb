import java.util.Scanner;

public class ComputerPlayer {
    private int cp_score;
    private String cp_name;
    private final Scanner input = new Scanner(System.in);
    ComputerPlayer() {
    }

    public int getCp_score() {
        return cp_score;
    }

    public void setCp_score(int cp_score) {
        this.cp_score = cp_score;
    }

    public String getCp_name() {
        return cp_name;
    }

    public void setCp_name() {
        System.out.println("请选择对方的角色(1：刘备；2：孙权；3：曹操 )");
        int cp_numb = input.nextInt();
        switch (cp_numb) {
            case 1:  this.cp_name = "刘备";break;
            case 2: this.cp_name = "孙权";break;
            case 3: this.cp_name = "曹操";break;
            default:
                setCp_name();
        }
    }
    //返回一个小于4旳随机数用来代表猜拳结果
    public int play(){
        return (int) (Math.random() * 3) +1;
    }
}
