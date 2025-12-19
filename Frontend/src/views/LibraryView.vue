<template>
  <div class="container">
    <br></br><br></br><br></br><br></br>
    <div>
      <h1 class="text-5xl font-semibold tracking-tight text-balance text-gray-900 sm:text-7xl">Cool Facts Library</h1>
      <ul class="mt-8 text-lg font-medium text-pretty text-gray-500 sm:text-xl/8">
        <li v-for="(fact, index) in facts" :key="index">
          {{ fact }}<br></br><br></br>
        </li>
      </ul>
    </div>
  </div>
  <br></br>
</template>

<script>
export default {
  data() {
    return {
      facts: []
    };
  },
  mounted() {
    fetch("http://localhost:8080/facts")
      .then(res => res.json())
      .then(data => {
        this.facts = data;
      });
  }
};
</script>

<style scoped>

</style>