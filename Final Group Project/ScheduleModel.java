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
   public double getRecSleep() 
   {
      return Math.max(sleep, 7);
   }
   public double getRecStudy() 
   {
      return Math.max(study,2);
   }
   public double getRecWork() 
   {
      return Math.min(work,14);
   }
   public double getRecExercise() 
   {
      return Math.max(exercise,1);
   }
   public double getRecLeisure() 
   {
      return Math.max(leisure,2);
   }
   
   public ArrayList<String> getRecommendations()
   {
      ArrayList<String> rec = new ArrayList<>();
      if (sleep < 7) rec.add("Increase sleep to at least 7 hours.");
      if (study < 2) rec.add("Add more study time.");
      if (work > 12)rec.add("reduce work time");
      if (exercise < 1) rec.add("Add exercise.");
      if (leisure < 2) rec.add("Increase leisure time.");
      
      return rec;
   }
   public ArrayList<String> getConcerns() 
   {
      ArrayList<String> concerns = new ArrayList<>();
      
      if (sleep < 7) concerns.add("Low sleep.");
      if (study < 2) concerns.add("Low study time.");
      if (work > 12) concerns.add("Overloaded work");
      if (exercise < 1) concerns.add("Too little exercise");
      if (leisure < 2) concerns.add("Low leisure Time");
      return concerns;
   
   }
}
   
   
