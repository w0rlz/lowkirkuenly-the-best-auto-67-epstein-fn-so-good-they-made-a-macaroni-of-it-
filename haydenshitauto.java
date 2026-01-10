
    package org.firstinspires.ftc.teamcode;
    import com.qualcomm.robotcore.eventloop.opmode.OpMode;
    import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
    import com.bylazar.configurables.annotations.Configurable;
    import com.bylazar.telemetry.TelemetryManager;
    import com.bylazar.telemetry.PanelsTelemetry;
    import org.firstinspires.ftc.teamcode.pedroPathing.Constants;
    import com.pedropathing.geometry.BezierCurve;
    import com.pedropathing.geometry.BezierLine;
    import com.pedropathing.follower.Follower;
    import com.pedropathing.paths.PathChain;
    import com.pedropathing.geometry.Pose;

    @Autonomous(name = "YO GEMINI WHY LWK EPSTEIN", group = "Autonomous")
    @Configurable // Panels
    public class autohope extends OpMode {
      private TelemetryManager panelsTelemetry; // Panels Telemetry instance
      public Follower follower; // Pedro Pathing follower instance
      private AutoState pathState = AutoState.BEGIN ; // Current autonomous path state (state machine)
      private Paths paths; // Paths defined in the Paths class

        enum AutoState {
            BEGIN,
            DOING_PATH_ONE,
            DOING_PATH_TWO,
            DOING_PATH_3,
            DOING_PATH_4,
            DOING_PATH_5,
            DOING_PATH_6,
            DOING_PATH_7,
            DOING_PATH_8,
            DOING_PATH_9,
            DOING_PATH_10,
            DOING_PATH_11,
            DOING_PATH_12,
            DOING_PATH_13,
            DOING_PATH_14,
            WHAETBERR
        };

      @Override
      public void init() {
        panelsTelemetry = PanelsTelemetry.INSTANCE.getTelemetry();
        follower.setMaxPower(0.5);
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(new Pose(72, 8, Math.toRadians(270)));

        paths = new Paths(follower); // Build paths

        panelsTelemetry.debug("Status", "Initialized");
        panelsTelemetry.update(telemetry);
      }

      public void autonomousPathUpdate() {
          switch(pathState) {
              case BEGIN:
                    follower.followPath(paths.Path1, true);
                    setState(AutoState.DOING_PATH_ONE);
                  break;
              case DOING_PATH_ONE:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path2, true);
                      setState(AutoState.DOING_PATH_TWO);
                  }
                  break;
              case DOING_PATH_TWO:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path3, true);
                      setState(AutoState.DOING_PATH_3);
                  }
                  break;
              case DOING_PATH_3:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path4, true);
                      setState(AutoState.DOING_PATH_4);
                  }
                  break;
              case DOING_PATH_4:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path5, true);
                      setState(AutoState.DOING_PATH_5);
                  }
                  break;
              case DOING_PATH_5:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path6, true);
                      setState(AutoState.DOING_PATH_6);
                  }
                  break;
              case DOING_PATH_6:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path7, true);
                      setState(AutoState.DOING_PATH_7);
                  }
                  break;
              case DOING_PATH_7:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path8, true);
                      setState(AutoState.DOING_PATH_8);
                  }
                  break;
              case DOING_PATH_8:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path9, true);
                      setState(AutoState.DOING_PATH_9);
                  }
                  break;
              case DOING_PATH_9:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path10, true);
                      setState(AutoState.DOING_PATH_10);
                  }
                  break;
              case DOING_PATH_10:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path11, true);
                      setState(AutoState.DOING_PATH_11);
                  }
                  break;
              case DOING_PATH_11:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path12, true);
                      setState(AutoState.DOING_PATH_12);
                  }
                  break;
              case DOING_PATH_13:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path13, true);
                      setState(AutoState.DOING_PATH_13);
                  }
                  break;
              case DOING_PATH_14:
                  if(!follower.isBusy()) {
                      follower.followPath(paths.Path14, true);
                      setState(AutoState.WHAETBERR);
                  }
                  break;
              case WHAETBERR:
                  gamepad1.rumble(670);
                  break;
          };
      }

      public void setState(AutoState state) {
          pathState = state;
      }

      @Override
      public void loop() {
        follower.update(); // Update Pedro Pathing
          autonomousPathUpdate(); // Update autonomous state machine

        // Log values to Panels and Driver Station
        panelsTelemetry.debug("Path State", pathState);
        panelsTelemetry.debug("X", follower.getPose().getX());
        panelsTelemetry.debug("Y", follower.getPose().getY());
        panelsTelemetry.debug("Heading", follower.getPose().getHeading());
        panelsTelemetry.update(telemetry);
      }


  public static class Paths {
    public PathChain Path1;
public PathChain Path2;
public PathChain Path3;
public PathChain Path4;
public PathChain Path5;
public PathChain Path6;
public PathChain Path7;
public PathChain Path8;
public PathChain Path9;
public PathChain Path10;
public PathChain Path14;
public PathChain Path11;
public PathChain Path12;
public PathChain Path13;

    public Paths(Follower follower) {
      Path1 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(87.486, 8.220),

            new Pose(84.183, 11.119)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(270), Math.toRadians(247))

        .build();

Path2 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(84.183, 11.119),

            new Pose(103.367, 59.138)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(247), Math.toRadians(0))

        .build();

Path3 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(103.367, 59.138),

            new Pose(135.881, 59.028)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

        .build();

Path4 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(135.881, 59.028),

            new Pose(103.055, 58.844)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

        .build();

Path5 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(103.055, 58.844),

            new Pose(128.339, 62.569)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

        .build();

Path6 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(128.339, 62.569),

            new Pose(83.541, 82.661)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(225))

        .build();

Path7 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(83.541, 82.661),

            new Pose(96.541, 83.716)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(225), Math.toRadians(0))

        .build();

Path8 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(96.541, 83.716),

            new Pose(129.835, 83.385)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))

        .build();

Path9 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(129.835, 83.385),

            new Pose(83.688, 82.697)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(225))

        .build();

Path10 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(83.688, 82.697),

            new Pose(90.174, 34.982)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(225), Math.toRadians(0))

        .build();

Path14 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(90.174, 34.982),

            new Pose(136.294, 35.890)
          )
        ).setTangentHeadingInterpolation()

        .build();

Path11 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(136.294, 35.890),

            new Pose(110.761, 22.514)
          )
        ).setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(247))

        .build();

Path12 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(110.761, 22.514),

            new Pose(84.385, 10.862)
          )
        ).setTangentHeadingInterpolation()

        .build();

Path13 = follower.pathBuilder().addPath(
          new BezierLine(
            new Pose(84.385, 10.862),

            new Pose(84.477, 11.266)
          )
        ).setTangentHeadingInterpolation()

        .build();
    }
  }
    }
