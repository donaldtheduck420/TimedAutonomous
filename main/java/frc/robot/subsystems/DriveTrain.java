/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private static DriveTrain drive;
  private PWMTalonSRX left = new PWMTalonSRX(0);
  private PWMTalonSRX right = new PWMTalonSRX(1);
  private Encoder leftEncoder = new Encoder(0, 1);
  private Encoder rightEncoder = new Encoder(2, 3);

  public DriveTrain() {
    left.setInverted(true);
    leftEncoder.reset();
    rightEncoder.reset();
  }


  public void tankDrive(double leftPow, double rightPow){
    left.set(leftPow);
    right.set(rightPow);
  }

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public double returnDistance() {
    double leftDistance = leftEncoder.getDistance();
    double rightDistance = rightEncoder.getDistance();
    return (leftDistance + rightDistance)/2;
  }

  public void printDistance() {
    System.out.println(returnDistance());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand())
  }

  /*@Override //uncomment when xbox controller plugged
  public void periodic() {
    tankDrive(Robot.m_oi.xbox.getRawAxis(RobotMap.leftJoy), Robot.m_oi.xbox.getRawAxis(RobotMap.rightJoy));
  }*/
}
