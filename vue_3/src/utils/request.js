import axios from "axios";
import { ElMessage } from "element-plus";

const request = axios.create({
    baseURL: 'http://localhost:9090',
    timeout: 30000
})

request.interceptors.request.use(config => {
    config.headers['Content-Type'] = 'application/json;charset=utf-8'
    return config
}, error => {
    return Promise.reject(error)
});

request.interceptors.response.use(response => {
        let res = response.data;
        if(typeof res == 'string') {
            res = res ? JSON.parse(res) : res
        }
        return res;
    },
    error => {
        if(error.response.status === 404){
            ElMessage.error('未找到请求信息')
        }if(error.response.status === 500){
            ElMessage.error('服务器后端异常')
        }else{
            console.error(error.message)
        }
        return Promise.reject(error)
    }
)

export default request