import java.util.Scanner;

/**
 * @author liu
 */
public class Play {
    private static int round = 0;
    private static int flag = 0;
    private static final ComputerPlayer COMPUTER_PLAYER = new ComputerPlayer();
    private static final ManPlayer MAN = new ManPlayer();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*Scanner input = new Scanner(System.in);*/
        boolean res;
        do {
            System.out.println("**************");
            System.out.println("****猜拳开始***");
            System.out.println("**************");
            System.out.println("出拳规则：1 剪刀 2 石头 3 布");
            if (COMPUTER_PLAYER.getCp_name() == null || MAN.getM_name() == null) {
                COMPUTER_PLAYER.setCp_name();
                COMPUTER_PLAYER.setCp_score(0);
                MAN.setM_name();
                MAN.setM_score(0);
                System.out.println(MAN.getM_name() + "你选择" + COMPUTER_PLAYER.getCp_name() + "对战");
            }
            System.out.println("请出拳：1：剪刀；2：石头、3：布");
            int cpRandom = COMPUTER_PLAYER.play();
            int manNum = input.nextInt();
            String manResult = fit(manNum);
            String cpResult = fit(cpRandom);
            System.out.println("你出拳：" + manResult);
            System.out.println("电脑出拳：" + cpResult);
            if (cpRandom == 1 && manNum == 3 || cpRandom == 2 && manNum == 1 || cpRandom == 3 && manNum == 2) {
                System.out.println("你真菜，你输给了" + COMPUTER_PLAYER.getCp_name());
                int cps = COMPUTER_PLAYER.getCp_score() + 1;
                COMPUTER_PLAYER.setCp_score(cps);
            }
            if (cpRandom == 3 && manNum == 1 || cpRandom == 1 && manNum == 2 || cpRandom == 2 && manNum == 3) {
                System.out.println("你真牛，你赢了" + COMPUTER_PLAYER.getCp_name());
                int mans = MAN.getM_score() + 1;
                MAN.setM_score(mans);
            }
            if (cpRandom == manNum) {
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
        System.out.println(COMPUTER_PLAYER.getCp_name() + "VS" + MAN.getM_name());
        System.out.println("对阵次数" + round);
        System.out.println("姓名     的分");
        System.out.println(COMPUTER_PLAYER.getCp_name() + "    " + COMPUTER_PLAYER.getCp_score());
        System.out.println(MAN.getM_name() + "    " + MAN.getM_score());
        System.out.println("  平局  " + flag);
        int last = COMPUTER_PLAYER.getCp_score() - MAN.getM_score();
        if (last > 0) {
            System.out.println(COMPUTER_PLAYER.getCp_name() + "取得最后的胜利");
        } else if (last == 0) {
            System.out.println("平局");
        } else {
            System.out.println(MAN.getM_name() + "取得最后的胜利");
        }
    }
}
