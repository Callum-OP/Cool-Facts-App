<template>
  <div class="container">
    <br></br><br></br><br></br><br></br>
    <div>
      <h1 class="text-5xl font-semibold tracking-tight text-balance text-gray-900 sm:text-7xl">Cool Facts Library</h1>
      <ul class="mt-8 text-lg font-medium text-pretty text-gray-500 sm:text-xl/8">
        <li v-for="(fact, index) in facts" :key="index">
          {{ fact.id }} : {{ fact.text }}
          <button  @click="deleteFact(fact.id)" class="flex-shrink-0 bg-red-500 hover:bg-red-700 border-red-500 hover:border-red-700 text-sm border-4 text-white py-1 px-2 rounded">
            Delete
          </button>
          <br></br><br></br>
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
  // Get all facts
  mounted() {
    fetch("http://localhost:8080/facts")
      .then(res => res.json())
      .then(data => {
        this.facts = data;
      });
  },
  methods: {
    // Function to delete fact using ID
    async deleteFact(id) {
      await fetch(`http://localhost:8080/fact/${id}`, {method: "DELETE"})
        .then(() => { window.location.reload(); }); // Refresh page
    }
  }
};
</script>

<style scoped>

</style>