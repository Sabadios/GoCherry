@cls

@echo on

@set launch_args=-ea -mx1G -XX:PermSize=384M -XX:MaxPermSize=768M -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:SurvivorRatio=4 -XX:+DisableExplicitGC
@set launch_args=%launch_args% -jar GoCherry.Launcher-1.0.0.jar -configFile app-cfg.json

@call java -jar %launch_args%
