class Start{
    public static void main(String[] data){
        // System.out.println("HI");
//        double[][] m;           // declaring
//        m = new double[3][4];   // Allocate 
//        m[0][1] = 8.3;          // assign i cell
//        m[1][0] = 8.5;
//        m[1][1] = 8.4;
//        m[1][2] = 8.7;
//        m[1][3] = 8.5;
//        m[2][3] = 8.6;
        
        //find the number of row
        //System.out.println(m.length);
        
        // but number of column probably not equal
        // we use the first row
        //System.out.println(m[0].length);
        
        // print each cell from column 2
        //for(int r = 0; r<m.length; r++){
            //System.out.println(m[r][2]);
        //}
        
        // print each cell from row 1
        //for(int l=0; l < m[0].length; l++){
            //System.out.println(m[1][l]);
        //}
        
        // print all information
        //for(int c=0; c < m.length;c++){
            // System.out.print(" ");
            //for(int d=0; d < m[c].length;d++){
                //System.out.print(" " + m[c][d]);
            //}
        //}

        //print sum of each row
        //double sum = 0;
        //for(int e=0; e < m.length;e++){
            //for(int f=0; f < m[e].length;f++){
            //    sum += m[e][f];
//                System.out.print(" " + m[e][f]);
            //}
            //System.out.println("Sum of row "+ e + " is: " + sum);
        //}
        
        
        int[][] t = {
            {8, 5, 2, 6},
            {6, 4, 1, 3},
            {7, 8, 3, 7},
            {6, 9, 8, 3},
            {5, 1, 8, 4}
        };
        // sumRow , sum Column
//        int sum = 0;
//        int sum_ = 0;
//        int row = 2;
//        int column = 3;
//        for(int e=0; e < t[0].length;e++){
//            sum += t[row][e];
//        }
//        System.out.println(sum);
//        
//        for(int f=0; f < t.length;f++){
//            sum_ += t[f][column];
//        }
//        System.out.print(sum_);


        // sum around number
        Tool tool = new Tool();
        int sum = tool.sumNeighbor(t,0,0);
        System.out.println(sum);
        
        
        // kbgt
        int[] R = {2,1,0,2};
        int[] C = {0,2,1,2};
        tool.process(4, R, C);
    }
}


class Tool{
    int sumNeighbor(int[][] t, int r ,int c){
        int result = 0;
        for(int i = -1; i <=1 ; i++){
            for(int j= -1; j <=1 ; j++){
                if(r+i >= 0 && r+i < t.length && c+j >= 0 && c+j < t[r].length){
                    result = result + t[r+i][c+j];
                }
            }
        }
        return result - t[r][c];
    }
    
    void process(int N ,int[] R ,int[] C){
        char[][] board = new char[N][N];
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                board[r][c] = '0';
            }
        }
        for(int i = 0; i < R.length; i++){
            int r = R[i];
            int c = C[i];
            board[r][c] = 'B';
        }
        for(int r=0; r<N; r++){
            for(int c=0;c<N;c++){
                int count = count(board,r,c);
                board[r][c] = (char)(count + '0');
            }
        }
        for(int i = 0; i < N;i++){
            for(int j=0; j < N;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    int count(char[][] board, int r, int c){
        int bomb = 0;
        for(int i=-1; i<=1;i++){
            for(int j=-1; j<=1;j++){
                if(r+i>=0 && r+i < board.length && c+j>=0 && c+j < board.length){
                    if(board[r+i][c+j] == 0){
                        bomb +=1;
                    }
                }
            }
        }
        return bomb;
    }
}