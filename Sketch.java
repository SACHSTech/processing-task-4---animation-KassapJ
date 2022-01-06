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
  public float starOpacity = 255;
  public float starSpeed = 255 / 60;

	
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
    
    susX = (width/2) + cos((float) angle) * 300;
    susY = height + sin((float) angle) * 300;

    angle += (float) 0.1;

      //stars
      

      noStroke();
      starOpacity += starSpeed;

      if(starOpacity < 0 || starOpacity > 255){
        starSpeed *= -1;
      }

      fill(255, 255, 255, starOpacity);
      ellipse(100, 100, scale / 10, scale / 10);
      ellipse(125, 200, scale / 10, scale / 10);
      ellipse(150, 170, scale / 10, scale / 10);
      ellipse(200, 100, scale / 10, scale / 10);
      ellipse(300, 223, scale / 10, scale / 10);
      ellipse(220, 200, scale / 10, scale / 10);
      ellipse(310, 160, scale / 10, scale / 10);
      ellipse(240, 2300, scale / 10, scale / 10);
      ellipse(130, 230, scale / 10, scale / 10);
      
      
      

      //window
      fill(240);
      rect(0, 0, width, height / 8);
      rect(0, 350, width, height / 8);
      rect(0, 0, width / 8, height);
      rect(350, 0, width / 8, height);

    
  
  }
  // define other methods down here.


}