<template>

    <div>
        <!-- 头部区域 -->
        <div class="header">头部</div>
        <!-- 左侧区域 -->
        <div class="navbar" style="border: 100vh - 60px;">
            <el-menu default-active="/layout/home" style="border-right: 1px solid #ddd; height: calc(100vh - 60px);" router>
                <el-menu-item index="/layout/home">
                    <el-icon>
                        <setting />
                    </el-icon>
                    <span>系统首页</span>
                </el-menu-item>
                <el-sub-menu index="1">
                    <template #title>
                        <el-icon>
                            <location />
                        </el-icon>
                        <span>用户管理</span>
                    </template>
                    <el-menu-item index="1-1">
                        TODO
                    </el-menu-item>
                    <el-menu-item index="/layout/search">数据展示</el-menu-item>
                </el-sub-menu>
                <el-menu-item index="2">
                    <el-icon>
                        <setting />
                    </el-icon>
                    <span>数据统计</span>
                </el-menu-item>
            </el-menu>
        </div>
        <!-- 右侧区域 -->
        <div class="main">
            <router-view />

        </div>
    </div>
</template>

<script setup>
    
</script>

<style scoped>
/* 头部样式 */
.header {
    position: absolute;
    line-height: 60px;
    top: 0px;
    left: 0px;
    right: 0px;
    background-color: #bed3ed;
}

/* 左侧样式 */
.navbar {
    position: absolute;
    width: 200px;
    top: 60px;
    left: 0px;
    bottom: 0px;
    overflow-y: auto;
}

/* 主区域 */
.main {
    position: absolute;
    padding: 10px;
    top: 60px;
    left: 200px;
    bottom: 0px;
    right: 0px;
    padding: 10px;
    overflow-y: auto;
    background-color: rgb(252, 253, 239);
}
</style>