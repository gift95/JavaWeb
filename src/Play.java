import java.util.Scanner;

/**
 * @author liu
 */
public class Play {
    private static int round = 0;
    private static int flag = 0;
    private static final ComputerPlayer cp = new ComputerPlayer();
    private static final ManPlayer man = new ManPlayer();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*Scanner input = new Scanner(System.in);*/
        boolean res;
        do {
            System.out.println("**************");
            System.out.println("****猜拳开始***");
            System.out.println("**************");
            System.out.println("出拳规则：1 剪刀 2 石头 3 布");
            if (cp.getCp_name() == null || man.getM_name() == null) {
                cp.setCp_name();
                cp.setCp_score(0);
                man.setM_name();
                man.setM_score(0);
                System.out.println(man.getM_name() + "你选择" + cp.getCp_name() + "对战");
            }
            System.out.println("请出拳：1：剪刀；2：石头、3：布");
            int cp_radom = cp.play();
            int man_num = input.nextInt();
            String manresult = fit(man_num);
            String cpresult = fit(cp_radom);
            System.out.println("你出拳：" + manresult);
            System.out.println("电脑出拳：" + cpresult);
            if (cp_radom == 1 && man_num == 3 || cp_radom == 2 && man_num == 1 || cp_radom == 3 && man_num == 2) {
                System.out.println("你真菜，你输给了" + cp.getCp_name());
                int cps = cp.getCp_score() + 1;
                cp.setCp_score(cps);

            }
            if (cp_radom == 3 && man_num == 1 || cp_radom == 1 && man_num == 2 || cp_radom == 2 && man_num == 3) {
                System.out.println("你真牛，你赢了" + cp.getCp_name());
                int mans = man.getM_score() + 1;
                man.setM_score(mans);
            }
            if (cp_radom == man_num) {
                System.out.println("平手");
                flag++;
            }
            System.out.println("还要再玩一局么？true/false");
            round++;
            res = input.hasNext("true");
        } while (res);
        show();
    }

    private static String fit(int num) {
        switch (num) {
            case 1:
                return "剪刀";
            case 2:
                return "石头";
            case 3:
                return "布";
            default:
                return fit(num);
        }
    }

    private static void show() {
        System.out.println(cp.getCp_name() + "VS" + man.getM_name());
        System.out.println("对阵次数" + round);
        System.out.println("姓名     的分");
        System.out.println(cp.getCp_name() + "    " + cp.getCp_score());
        System.out.println(man.getM_name() + "    " + man.getM_score());
        System.out.println("  平局  " + flag);
        int last = cp.getCp_score() - man.getM_score();
        if (last > 0) {
            System.out.println(cp.getCp_name() + "取得最后的胜利");
        } else if (last == 0) {
            System.out.println("平局");
        } else {
            System.out.println(man.getM_name() + "取得最后的胜利");
        }
    }
}
