import processing.core.PApplet;

public class Sketch extends PApplet {


  /**
   * state global variables
   *  
   * */ 
  public float susX = 0;
  public float susY = 0;
  public float Xspeed = 10;
  public float angle = 0;
  public float red = 0;
  public float blue = 0;
  public float green = 0;
  public float redSpeed = (float) (254 / 60);
  public float blueSpeed = (float) (135 / 60);
  public float greenSpeed = (float) (20 / 60);

	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	  // put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw(){
    background(0);
    smooth();

    float scale = 50;
    float legDistanceY = (float) (scale * 1.5);
    float legSlightMove = scale / 8;
    float backpackDistanceX = scale / 5;
    float backpackDistanceY = scale / 4;
    float maskDistanceY = scale / 3;
  
    //background
    red += redSpeed;
    green += greenSpeed;
    blue += blueSpeed;
    
    if(red < 0 || red > 254){
      redSpeed *= -1;
    }
    
    if(blue < 0 || blue > 135){
      blueSpeed *= -1;
    }
    
    if(green < 0 || green > 20){
      greenSpeed *= -1;
    }

    background(red, green, blue);


    //among us #1
    noStroke();
    fill(199,16,18);
    //body
    rect(susX, susY, scale, (float) (scale * 1.5));
    //round head
    ellipse((float) (susX + scale/2), susY, scale, (float) (scale * 0.5));
    //legs
    ellipse((float) (susX + legSlightMove), susY + legDistanceY, scale / 4, scale / 2);
    ellipse((float) (susX - legSlightMove)+ scale, susY + legDistanceY, scale / 4, scale / 2);
    //backpack
    rect(susX - backpackDistanceX , susY + backpackDistanceY, scale, scale);
    //mask
    stroke(0);
    strokeWeight(scale / 50);
    fill(149,202,220);
    ellipse(susX + scale, susY + maskDistanceY, (float) (scale * 0.75), (float) (scale * 0.5));

    //circleX = origin(point x) + cos0 * 50(length of the x value)
    //circleY = origin(point y) + cos0 * 50(length of the y value)
    
    susX = 200 + cos((float) angle) * 50;
    susY = 200 + sin((float) angle) * 50;

    angle += (float) 0.1;

    
  
  }
  // define other methods down here.


}