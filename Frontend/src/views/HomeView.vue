<template>
  <div class="container">
    <br></br>
    <div class="text-center">
      <h1 class="text-5xl font-semibold tracking-tight text-balance text-gray-900 sm:text-7xl">Cool Facts</h1>
      <div class="mt-10 flex items-center justify-center gap-x-6">
        <button @click="getFact" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">Show me a fact</button>
      </div>
      <p class="mt-8 text-lg font-medium text-pretty text-gray-500 sm:text-xl/8" v-if="fact">{{ fact }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      fact: null
    };
  },
  methods: {
    async getFact() {
      fetch("http://localhost:8080/fact")
        .then(res => res.text())
        .then(data => this.fact = data);
    }
  }
};
</script>

<style scoped>
.container {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
}
</style>