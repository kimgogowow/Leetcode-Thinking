class Solution {
    public String removeKdigits(String num, int k) {
        //the sequence of the rest can not be changed
        if(k == num.length())
            return "0";
        Stack<Character> stack = new Stack<>();
        //stack.peek()>char ->stack.pop(),count++
        for(int i = 0;i < num.length();i++){
            while(!stack.isEmpty() && k>0 && num.charAt(i)<stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        System.out.println("stack is "+stack+" k is "+k);

        String res = "";
        for(char c : stack){
            res +=c;//res = 0001 , k =3
        }

        //what if the num is ascending sorted
        if(k>0 && res.length()>k){
            res =res.substring(0,res.length()-k);//res[0,1) = 0
            System.out.println("res is "+res);
        }

        while(res.length()>1 && res.charAt(0) == '0'){
            res = res.substring(1);
        }
        return res;
    }
}