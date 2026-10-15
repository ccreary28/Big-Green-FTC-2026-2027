package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;

public class AprilTagLimelight extends OpMode {
    private Limelight3A limelight;
    private DcMotor backLeft, frontLeft, backRight, frontRight;

    @Override
    public void init(){

        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(8); // index is the pipeline chosen on limelight manager page

        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");


    }

    @Override
    public void start(){
        limelight.start();
    }

    @Override
    public void loop(){

        LLResult llResult = limelight.getLatestResult();

        if (llResult != null && llResult.isValid()) {
            Pose3D botpose = llResult.getBotpose();
            telemetry.addData("target x", llResult.getTx());
            telemetry.addData("target y", llResult.getTy());
            telemetry.addData("target area", llResult.getTa());
        }
    }

}
