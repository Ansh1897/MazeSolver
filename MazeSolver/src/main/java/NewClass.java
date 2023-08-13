import org.example.DepthFirst;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewClass extends JFrame {
    private int [][] maze = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,1,0,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,1,1,1,0,1},
            {1,0,1,1,1,1,1,0,0,0,0,0,1},
            {1,0,0,1,0,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,0,0,1},
            {1,0,1,0,1,0,0,0,1,1,1,0,1},
            {1,0,1,0,1,1,1,0,1,0,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,1,9,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };

    //Stores the coordinates of the path to the destination
    public List<Integer> path = new ArrayList<>();

    public NewClass(){
        setTitle ("Maze Solver");
        setSize(720, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze,1,1,path);
        System.out.println(path);

    }

    @Override
    public void paint(Graphics c){
        c.translate(50,50);
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                Color color;
                switch(maze[i][j]){
                    case 1: color = Color.DARK_GRAY; break;
                    case 9: color = Color.ORANGE; break;
                    default: color = Color.white; break;
                }
                c.setColor(color);
                c.fillRect(30*j, 30*i, 30, 30);
                c.setColor(Color.red);
                c.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i = 0; i<path.size();i+=2){
            int pathx = path.get(i);
            int pathy = path.get(i+1);

            c.setColor(Color.green);
            c.fillRect(30*pathx,30*pathy, 20,20);

        }

    }


    public static void main(String [] args){
        NewClass view = new NewClass();
        view.setVisible(true);
    }
}
