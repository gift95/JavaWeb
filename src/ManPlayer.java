import java.util.Scanner;

public class ManPlayer {
public int m_score;
public  String m_name;
    Scanner input = new Scanner(System.in);
    public ManPlayer() {
    }

    public ManPlayer(int m_score, String m_name) {
        this.m_score = m_score;
        this.m_name = m_name;
    }

    public int getM_score() {
        return m_score;
    }

    public void setM_score(int m_score) {
        this.m_score = m_score;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name() {
        System.out.println("请输入你的姓名");
        this.m_name = input.next();
    }

}
