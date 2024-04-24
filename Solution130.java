class Solution130 {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        if(row <= 0 || col <= 0) return;
        //borders mark
        for(int i = 0;i < row ;i++){
            dfs(board,i,0);//left
            dfs(board,i,col-1);
        }
        for(int i = 0; i < col;i++){
            dfs(board,0,i);//up
            dfs(board,row-1,i);
        }

        //traverse the board and make t back to o, o to x
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }

    }
    public void dfs(char[][] board,int row,int col){
        //corner case
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O'){
            return;
        }
        board[row][col] = 'T';
        dfs(board,row+1,col);
        dfs(board,row-1,col);
        dfs(board,row,col+1);
        dfs(board,row,col-1);
    }
}
