Skip to content
 
Search…
All gists
GitHub
New gist
@kathelas 
 Edit
  Delete
  Star 0 @kathelaskathelas/day3.java
Created 13 hours ago
Embed  
<script src="https://gist.github.com/kathelas/8309bddfd709a3c9c8e9e0f2c604b98f.js"></script>
  Download ZIP
 Code  Revisions 1
advent of code day 3
Raw
 day3.java
public class Main {

    public static void main(String[] args) {

        int input = 347991;
        System.out.println("Distance: " + distance(input));
        System.out.println("Value: " + value(input));

    }





    public static int distance(int input) {
        int x = 0;
        int y = 0;
        int max_x = 0;
        int min_x = 0;
        int max_y = 0;
        int min_y = 0;

        int direction = 0;

        int square = 1;


        while (square < input) {

            //right
            if (direction == 0) {
                while (x <= max_x) {
                    x++;
                    square++;
                    if (square == input)
                        break;
                }
                if (max_x < x) {
                    max_x = x;
                    direction = 1;
                }
                continue;
            }

            //up
            if (direction == 1) {
                while (y <= max_y) {
                    y++;
                    square++;
                    if (square == input)
                        break;
                }
                if (max_y < y) {
                    max_y = y;
                    direction = 2;
                }
                continue;
            }

            //left
            if (direction == 2) {
                while (x >= min_x) {
                    x--;
                    square++;
                    if (square == input)
                        break;
                }
                if (min_x > x) {
                    min_x = x;
                    direction = 3;
                }
                continue;
            }

            //down
            if (direction == 3) {
                while (y >= min_y) {
                    y--;
                    square++;
                    if (square == input)
                        break;
                }
                if (min_y > y) {
                    min_y = y;
                    direction = 0;
                }
            }
        }

        if(x < 0)
            x = x * -1;
        if(y < 0)
            y = y * -1;

        return (x + y);
    }


    public static int value(int input){
        int x = 0;
        int y = 0;
        int max_x = 0;
        int min_x = 0;
        int max_y = 0;
        int min_y = 0;

        int direction = 0;

        int square = 1;

        int a = (int) Math.sqrt(input);

        int[][] values = new int[a][];
        for(int i=0; i < a; i++)
            values[i] = new int[a];

        int start = a / 2;

        values[start][start] = 1;



        while (square < input) {

            //right
            if (direction == 0) {
                while (x <= max_x) {
                    x++;
                    square++;
                    values[start+x][start+y] = values[start+(x+1)][start+y] + values[start+x][start+(y+1)] + values[start+(x-1)][start+y] + values[start+x][start+(y-1)] + values[start+(x+1)][start+(y+1)] + values[start+(x+1)][start+(y-1)] + values[start+(x-1)][start+(y+1)] + values[start+(x-1)][start+(y-1)];
                    if(values[start+x][start+y] > input)
                        return values[start+x][start+y];
                    if (square == input)
                        break;
                }
                if (max_x < x) {
                    max_x = x;
                    direction = 1;
                }
                continue;
            }

            //up
            if (direction == 1) {
                while (y <= max_y) {
                    y++;
                    square++;
                    values[start+x][start+y] = values[start+(x+1)][start+y] + values[start+x][start+(y+1)] + values[start+(x-1)][start+y] + values[start+x][start+(y-1)] + values[start+(x+1)][start+(y+1)] + values[start+(x+1)][start+(y-1)] + values[start+(x-1)][start+(y+1)] + values[start+(x-1)][start+(y-1)];
                    if(values[start+x][start+y] > input)
                        return values[start+x][start+y];
                    if (square == input)
                        break;
                }
                if (max_y < y) {
                    max_y = y;
                    direction = 2;
                }
                continue;
            }

            //left
            if (direction == 2) {
                while (x >= min_x) {
                    x--;
                    square++;
                    values[start+x][start+y] = values[start+(x+1)][start+y] + values[start+x][start+(y+1)] + values[start+(x-1)][start+y] + values[start+x][start+(y-1)] + values[start+(x+1)][start+(y+1)] + values[start+(x+1)][start+(y-1)] + values[start+(x-1)][start+(y+1)] + values[start+(x-1)][start+(y-1)];
                    if(values[start+x][start+y] > input)
                        return values[start+x][start+y];
                    if (square == input)
                        break;
                }
                if (min_x > x) {
                    min_x = x;
                    direction = 3;
                }
                continue;
            }

            //down
            if (direction == 3) {
                while (y >= min_y) {
                    y--;
                    square++;
                    values[start+x][start+y] = values[start+(x+1)][start+y] + values[start+x][start+(y+1)] + values[start+(x-1)][start+y] + values[start+x][start+(y-1)] + values[start+(x+1)][start+(y+1)] + values[start+(x+1)][start+(y-1)] + values[start+(x-1)][start+(y+1)] + values[start+(x-1)][start+(y-1)];
                    if(values[start+x][start+y] > input)
                        return values[start+x][start+y];
                    if (square == input)
                        break;
                }
                if (min_y > y) {
                    min_y = y;
                    direction = 0;
                }
            }
        }

        return 0;

    }

}
 @kathelas
  
            
 
Write  Preview

Leave a comment
Choose Files Attach files by dragging & dropping, selecting them, or pasting from the clipboard.  Styling with Markdown is supported
Comment
1
© 2017 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
API
Training
Shop
Blog
About
