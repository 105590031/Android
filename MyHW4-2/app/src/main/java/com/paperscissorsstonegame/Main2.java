package com.paperscissorsstonegame;

/**
 * Created by User on 2018/4/9.
 */

public class Main2 {
    private static final short HUM = 0;
    private static final short COM = 1;
    private static final short TIE = 2;
    private static short[][] map = {{TIE, COM, HUM}, {HUM, TIE, COM}, {COM, HUM, TIE}};

    private int CChoice;
    private short result;

    public Main2(int PChoice) {
        this.CChoice = (int)(Math.random() * 3 + 1);
        this.result = map[PChoice - 1][CChoice - 1];
    }

    public String getComputerChoice() {
        switch (CChoice) {
            case 1:  return "剪刀";
            case 2:  return "石頭";
            default: return "布";
        }
    }

    public String getResult() {
        switch (result) {
            case HUM: return "判定輸贏：恭喜，你贏了！";
            case COM: return "判定輸贏：很可惜，你輸了！";
            default:  return "判定輸贏：雙方平手！";
        }
    }

}
