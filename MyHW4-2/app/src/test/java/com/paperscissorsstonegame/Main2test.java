package com.paperscissorsstonegame;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 2018/4/11.
 */

public class Main2test {
    private Main2 machine;

    @After
    public void tearDown() {
        machine = null;
    }

    @Test
    public void WinIsPlayer() {
        String result = "";

        while (!result.equals("判定輸贏：恭喜，你贏了！")) {



            machine = new Main2(1);
            result = machine.getResult();
        }
        assertEquals("判定輸贏：恭喜，你贏了！", result);
    }

    @Test
    public void WinIsComputer() {
        String result = "";
        while (!result.equals("判定輸贏：很可惜，你輸了！")) {



            machine = new Main2(2);
            result = machine.getResult();
        }
        assertEquals("判定輸贏：很可惜，你輸了！", result);
    }

    @Test
    public void Draw() {
        String result = "";
        while (!result.equals("判定輸贏：雙方平手！")) {

            machine = new Main2(3);
            result = machine.getResult();
        }
        assertEquals("判定輸贏：雙方平手！", result);
    }

    @Test
    public void ComputerScissors() {
        String result = "";
        while (!result.equals("剪刀")) {

            machine = new Main2(1);
            result = machine.getComputerChoice();
        }
        assertEquals("剪刀", result);
    }

    @Test
    public void ComputerRock() {
        String result = "";
        while (!result.equals("石頭")) {

            machine = new Main2(2);
            result = machine.getComputerChoice();
        }
        assertEquals("石頭", result);
    }

    @Test
    public void ComputerPaper() {
        String result = "";
        while (!result.equals("布")) {
            machine = new Main2(3);

            result = machine.getComputerChoice();
        }
        assertEquals("布", result);
    }
}

