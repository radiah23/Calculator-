public class CalculatePostfix {

    public static Double postfixToResult(Queue<Object> tokens) {
        Stack<Double> newStack = new Stack<>();
        //used ai to understand how to parse the token into single doubles
        while (tokens.isEmpty() == false) {
            Object token = tokens.dequeue();
            if (token instanceof Double) {
                newStack.push((Double) token); //casting because it is a queue object

                //we need to push it to the stack
                // newStack.push(token); this showed a lot of squiggly lunes because it says it needs a double. but my thing is it is double already right
            }

            else if (token instanceof Character) {
                char operator = (Character) token;
            // 1. `pop()` two numbers off the stack
            //error messages : 
            //if there is not even 2 eleemtns
                if (newStack.size() < 2) {
                    throw new IllegalArgumentException("Insufficient Numbers. Atleast have 2 numbers");
                }
                double r = newStack.pop();
                double k = newStack.pop();
            // combine them using the **operator**
            // did not understand how to combine so consulted ai here
                double result = 0.0; //just want to initialize  
                if (operator == '+'){
                    result = k+r;
                }
                else if(operator == '-'){
                    result = k-r;
                }

                else if (operator == '/') {
                    if (r == 0.0) {
                        throw new IllegalArgumentException("Cannot divide by 0");
                    }
                    result = k / r;
                }

                else if (operator == '*'){
                    result = k*r;
                }
    //ok now what if those are not the operator we want 
    //my idea was to see if the operator belongs to [+,-,*,/] but thats sort of pythonish 
                else{
                    throw new IllegalArgumentException("The operator does not belong in : [+,-,*,/]");
                }
                newStack.push(result);
                System.out.println(result);
            }
        }
        return newStack.pop();
    }

    public static void main(String[] args){
        String test = args[0];
        Queue<Object> tokens = Tokenizer.readTokens(test);
        System.out.println(tokens);
        Double result = postfixToResult(tokens);
        System.out.println("Answer: " + result);
    }
}