import java.util.HashMap;
import java.util.Map;

public class BayesianGritNetwork {

    // States for our variables
    enum Level { HIGH, LOW }

    public static void main(String[] args) {

        // 1. Define the Evidence (Input variables)
        Level myTalent = Level.LOW;
        Level myGrit = Level.HIGH;

        // 2. Run Inference
        double successProbability = calculateSuccess(myTalent, myGrit);

        System.out.println("--- Bayesian Inference Report ---");
        System.out.println("Input Talent: " + myTalent);
        System.out.println("Input Grit:   " + myGrit);
        System.out.println("Probability of Achievement: " + (successProbability * 100) + "%");
    }

    /**
     * This represents the Conditional Probability Table (CPT) for the Achievement node.
     * P(Achievement = SUCCESS | Talent, Grit)
     */
    public static double calculateSuccess(Level talent, Level grit) {
        // CPT Logic:
        // High Talent + High Grit = 95% Success
        // Low Talent  + High Grit = 70% Success (The "Grit" Factor)
        // High Talent + Low Grit  = 40% Success (The "Wasted Talent" Factor)
        // Low Talent  + Low Grit  = 5%  Success

        if (talent == Level.HIGH && grit == Level.HIGH) return 0.95;
        if (talent == Level.LOW  && grit == Level.HIGH) return 0.70;
        if (talent == Level.HIGH && grit == Level.LOW)  return 0.40;
        if (talent == Level.LOW  && grit == Level.LOW)  return 0.05;

        return 0.0;
    }
}