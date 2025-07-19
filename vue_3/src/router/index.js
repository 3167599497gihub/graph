import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      redirect: '/layout/home'
    },
    {
      path: '/layout',
      name: 'layout', // 路由名称
      component: () => import('../components/Layout/Layout.vue'),// 组件对象
      children: [
        {
          path: 'home',
          meta: { title: "主页" },
          component: () => import('../views/HomeView.vue'),
        },
        {
          path: 'Search',
          meta: { title: "数据展示" },
          component: () => import('../views/SearchView.vue'),
        }
      ],
    },
  ],
})

router.beforeEach((to, from) => {
    document.title = to.meta.title;
  }
)

export default router
