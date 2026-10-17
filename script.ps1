$Temp = Join-Path $env:TEMP "AetherPluginTemplate"
$Zip = Join-Path $env:TEMP "AetherPluginTemplate.zip"

Invoke-WebRequest `
    -Uri "https://github.com/m4gr3d/GDExtension-Android-Plugin-Template/archive/refs/heads/main.zip" `
    -OutFile $Zip

Expand-Archive -Path $Zip -DestinationPath $Temp -Force

$Template = Join-Path $Temp "GDExtension-Android-Plugin-Template-main"
$Target = "D:\Project\Aether\apps\aether_android_plugin"

New-Item -ItemType Directory -Force -Path $Target | Out-Null

Copy-Item `
    -Path "$Template\*" `
    -Destination $Target `
    -Recurse -Force
