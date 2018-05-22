package org.usfirst.frc.team319.robot.subsystems;

import org.usfirst.frc.team319.models.BobTalonSRX;
import org.usfirst.frc.team319.models.LeaderBobTalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {


	public LeaderBobTalonSRX leftLead = new LeaderBobTalonSRX(9, new BobTalonSRX(13)); //

    public void initDefaultCommand() {

		
		leftLead.setInverted(false);
		leftLead.setInverted(true);
		
		leftLead.configOpenloopRamp(36);
		leftLead.configOpenloopRamp(36);
    	
    }
}

