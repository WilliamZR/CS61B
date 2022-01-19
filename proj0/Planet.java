/** body program for CS61B project 0*/

public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
		xxPos=xP;
		xxVel=xV;
		yyPos=yP;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}

	public Planet(Planet b){
		xxPos=b.xxPos;
		xxVel=b.xxVel;
		yyPos=b.yyPos;
		yyVel=b.yyVel;
		mass=b.mass;
		imgFileName=b.imgFileName;
	}

	public double calcDistance(Planet b){
		double temp_x;
		double temp_y;
		double distance;
		temp_x=this.xxPos-b.xxPos;
		temp_y=this.yyPos-b.yyPos;
		distance=Math.sqrt(Math.pow(temp_x,2)
			+Math.pow(temp_y,2));
		return distance;
	}

	public double calcForceExertedBy(Planet b){
		double force;
		double constant=6.67*Math.pow(10,-11);
		force=this.mass*b.mass*constant/Math.pow(calcDistance(b),2);
		return force;
	}

	public double calcForceExertedByX(Planet b){
		double force_x;
		double temp_x=b.xxPos-this.xxPos;
		force_x=calcForceExertedBy(b)*temp_x/calcDistance(b);
		return force_x;
	}

	public double calcForceExertedByY(Planet b){
		double force_y;
		double temp_y=b.yyPos-this.yyPos;
		force_y=calcForceExertedBy(b)*temp_y/calcDistance(b);
		return force_y;
	}

	public double calcNetForceExertedByX(Planet[] b){
		int i = 0;
		double net=0;
		for (i=0;i<b.length;i++){
			if (b[i].equals(this)){
				continue;
			}else{
			net= net + calcForceExertedByX(b[i]);
			}
		}
		return net;
	}

	public double calcNetForceExertedByY(Planet[] b){
		int i = 0;
		double net=0;
		for (i=0;i<b.length;i++){
			if (b[i].equals(this)){
				continue;
			}else{
			net= net + calcForceExertedByY(b[i]);
			}
		}
		return net;
	}

	public void update(double time,double force_x,double force_y){
		double acc_x=force_x/this.mass;
		double acc_y=force_y/this.mass;
		this.xxVel=this.xxVel+acc_x*time;
		this.yyVel=this.yyVel+acc_y*time;
		this.xxPos=this.xxVel*time+this.xxPos;
		this.yyPos=this.yyVel*time+this.yyPos;
	}
}