# PermissionL
申请权限
PermissionL主要是通过学习第一行代码写出来的，用于简化Android运行时权限用法的开源库

在项目的build.gradle中添加如下代码
```groovy
dependencies {
     ...
     implementation 'com.ljp.permissionl:permissionl:1.0.0'
}
```
然后在项目中可以通过以下方式来申请权限了
```kotlin
    L.request(this, android.Manifest.permission.CALL_PHONE) { b, list ->

        if (b) {
            Toast.makeText(this, "申请成功", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "list:${list[0]}", Toast.LENGTH_SHORT).show()
        }

    }
```
