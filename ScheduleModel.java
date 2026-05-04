/**
 * The ScheduleModel class represents a user's daily schedule.
 * 
 * This class is part of the Model in the MVC architecture.
 * It stores time allocations for different activities and
 * provides logic for generating recommendations, identifying
 * concerns, and calculating optimized schedule values.
 * 
 * Activities include:
 * - Sleep
 * - Study
 * - Work
 * - Exercise
 * - Leisure
 * 
 * The model ensures better balance by applying minimum and maximum thresholds.
 * 
 * 
 */
import java.util.ArrayList;

public class ScheduleModel
{
   private double sleep, study, work, exercise, leisure;

   public ScheduleModel(double sleep,double study,double work, double exercise,double leisure)
   {
      this.sleep = sleep;
      this.study = study;
      this.work = work;
      this.exercise = exercise;
      this.leisure = leisure;
   }

   public double getSleep() { 
      return sleep; }
   public double getStudy() { 
      return study; }
   public double getWork() { 
      return work; }
   public double getExercise() { 
      return exercise; }
   public double getLeisure() { 
      return leisure; }

   public double getTotal()
   {
      return sleep + study + work + exercise + leisure;
   }

   public double getProductiveHours()
   {
      return study + work;
   }

   public String getBalanceStatus()
   {
      double total = getTotal();
   
      if (total == 24)
      {
         return "Exactly 24 hours!";
      }
      return "";
   }

   public String getStressLevel()
   {
      if (sleep < 6)
      {
         return "High Stress";
      }
      else if (sleep < 7)
      {
         return "Moderate Stress";
      }
      else
      {
         return "Low Stress";
      }
   }

   public String getOutcome()
   {
      if (getTotal() != 24)
      {
         return "Invalid Schedule";
      }
   
      if (sleep < 6)
      {
         return "High Stress Schedule";
      }
   
      if (work > 12)
      {
         return "Overloaded Schedule";
      }
   
      return "Balanced Schedule";
   }
   
   public double getRecSleep() {
    return Math.max(7, Math.min(sleep, 9));
}

public double getRecStudy() {
    return Math.max(2, Math.min(study, 6));
}

public double getRecWork() {
    return Math.min(14, Math.max(work, 4));
}

public double getRecExercise() {
    return Math.max(1, Math.min(exercise, 2));
}

public double getRecLeisure() {
    return Math.max(2, Math.min(leisure, 4));
}


   public ArrayList<String> getRecommendations()
   {
      ArrayList<String> rec = new ArrayList<String>();
   
      if (sleep < 7) rec.add("Increase sleep to at least 7 hours.");
      if (study < 2) rec.add("Add more study time (minimum 2 hours).");
      if (work > 12) rec.add("Reduce work hours to avoid burnout.");
      if (exercise < 1) rec.add("Add at least 1 hour of exercise.");
      if (leisure < 2) rec.add("Increase leisure time for balance.");
   
      return rec;
   }

   public ArrayList<String> getConcerns()
   {
      ArrayList<String> concerns = new ArrayList<String>();
   
      if (sleep < 7) concerns.add("Low sleep affects recovery and focus.");
      if (study < 2) concerns.add("Not enough study time may hurt performance.");
      if (work > 12) concerns.add("Work overload can increase stress.");
      if (exercise < 1) concerns.add("Lack of exercise impacts health.");
      if (leisure < 2) concerns.add("Insufficient relaxation time.");
   
      return concerns;
   }
}

   
