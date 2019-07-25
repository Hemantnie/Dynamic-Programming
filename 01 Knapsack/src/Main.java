import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int[] weight = {1,2,3,4,5};
        int[] value = {1,4,4,5,7} ;
        int total = 9;
        ArrayList<Integer> trace = new ArrayList<>();
        int[][] res = new int[5][10];
        //intitialize 1st col as value 0;
        for(int i=0;i<5;i++){
            res[i][0] = 0;
        }
        //intitialize 1st row as value[0];
        for(int i=1;i<10;i++){
            res[0][i] = value[0];
        }
        //main algo

        for(int i=1;i<5;i++){
            for(int j = 1;j<10;j++){
                //if we can not put the new weight in the
                if(weight[i]>j){
                    res[i][j] = res[i-1][j];
                }
                else{
                    //we can include the new weight i.e weight[i]<=j
                    //we are doing res[i-1][j-weight[i]] because one value can be take only once
                     res[i][j] = Math.max(res[i-1][j],value[i]+res[i-1][j-weight[i]]);
                }
            }
        }

        //print 2-d array
        for(int i=0;i<5;i++){
            for(int j=0;j<10;j++){
                System.out.print(res[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        // tracing the solution
        int row = 4,col=9;
        while(row>0){
            if(res[row][col] == res[row-1][col]){
                //means we have not included this row
                row = row-1;
                continue;
            }else{
                //means we have included this row
                trace.add(weight[row]);
                col = col - weight[row];
                row = row -1;
            }
        }
        System.out.println();
        System.out.println(trace);
    }

}
