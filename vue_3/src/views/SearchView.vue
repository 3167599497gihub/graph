<template>
    <!-- 搜索区域 -->
    <el-card>
        <div style="display: flex; height: 35px;">
            <el-input v-model="input" placeholder="请输入名称查询" :suffix-icon="Search" style="width: 480px;" />
            <div style="height: 35px; padding-top:2px; margin-left: 10px;">
                <el-button type="primary" @click="search">
                    查找
                </el-button>
            </div>
            <div style="height: 35px; padding-top:2px; margin-left: 10px;">
                <el-button type="info" @click="delete_search">
                    重置
                </el-button>
            </div>

        </div>
    </el-card>

    <el-card style="margin-top: 8px;">
        <div>
            <!-- TODO -->
            <el-button round @click="add">新增</el-button>
            <el-button type="success" round>批量导入</el-button>
            <el-button type="warning" round>删除</el-button>
            <el-button type="danger" round @click="delete_all_info">清空</el-button>
        </div>
    </el-card>
    <el-card style="margin-top: 8px;">
        <el-table :data="user_list" border style="width: 100%" show-overflow-tooltip>
            <el-table-column prop="logDate" label="注册日期" width="180" />
            <el-table-column prop="name" label="用户名" width="180" />
            <el-table-column prop="password" label="密码" width="180" />
            <el-table-column prop="latestDate" label="上次登录日期" width="180" />
        </el-table>
    </el-card>

    <div style="margin-top: 10px;margin-bottom: 16px;">
        <el-pagination v-model:current-page="currentPage" v-model:page-size="page_size" :page-sizes="[5, 10, 15, 20]"
            background layout="total, sizes, prev, pager, next, jumper" :total=all_data_size
            @size-change="loadpage" 
            @current-change="loadpage" />
    </div>
</template>

<script setup>
import request from '@/utils/request';
import { Search } from '@element-plus/icons-vue';
import { ref } from 'vue'

const input = ref('')
const search_info = ref()
const page_size = ref(15)
const currentPage = ref(1)
const disabled = ref(false)
const all_data_size = ref(0)
var user_list = ref([])

const load = () => {
    request.get('/user/selectall').then(res => {
        user_list.value = res.data
        all_data_size.value = res.data.length
    })
}

load();

const delete_search = () => {
    load();
};

const add = () => {
    console.log('compelete')
};

const delete_info = () => {
    console.log('compelete')
};


// TODO
const delete_all_info = () => {
    console.log('delete_all_info')
};


const search = () => {
    request.get('/user/selectbyname', {
        params: {
            name: input.value
        }
    }).then(res => {
        user_list.value = res.data
    })
};

const loadpage = () => {
    request.get('/user/selectpage', {
        params: {
            pageNum: currentPage.value,
            pageSize: page_size.value
        }
    }).then(res => {
        console.log(res.data)
        user_list.value = res.data.list
    }).catch(error => {
        console.error('加载数据失败:', error)
    })
}

</script>